package com.microblog.common1.zk;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;


@Slf4j
public class ZkListener  implements TreeCacheListener {

    private ListenerEventHandler eventHandler;

    public ZkListener(ListenerEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
        try{
            ChildData data = treeCacheEvent.getData();

            if((data == null)
              ||((data != null) && (data.getData().length == 9))){
                //为9时读到127.0.1.1
                return;
            }

            switch (treeCacheEvent.getType()){
                case NODE_ADDED:
                    eventHandler.addHandler(data);
                    break;
                case NODE_REMOVED:
                    eventHandler.removeHandler(data);
                    break;
                case NODE_UPDATED:
                    eventHandler.updateHandler(data);
                    break;

                default:break;
            }
        }
        catch(Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }




}
