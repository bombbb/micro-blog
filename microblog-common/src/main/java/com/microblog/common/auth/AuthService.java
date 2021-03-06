package com.microblog.common.auth;

import com.microblog.common.zk.ZkCli;
import com.microblog.common.zk.ZkCreateConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;

@Slf4j
public class AuthService {

    private final String rootPath = "/microblog";
    private final String subPath = "/microblog";

    private  ZkCli zkCli;

    private AuthInterceptorAdapter authInterceptorAdapter;




    public AuthService(ZkCli zkCli) {
        this.zkCli = zkCli;
    }


    public void registerAuthConfig(){

        ZkCreateConfig createConfig = ZkCreateConfig
                .builder()
                .createMode(CreateMode.EPHEMERAL)
                .path(getPath(authInterceptorAdapter.getAppName()))
                .build();
        String result  = zkCli.createPath(createConfig);
        if(result != null){


            zkCli.setData(getPath(authInterceptorAdapter.getAppName()),
                    authInterceptorAdapter.getAuthPaths());

            log.debug(""+authInterceptorAdapter);
        }

    }

    private String getPath(String appName){

        return rootPath + subPath + "/" + appName;
    }

    public void setAuthInterceptorAdapter(AuthInterceptorAdapter authInterceptorAdapter) {
        this.authInterceptorAdapter = authInterceptorAdapter;
    }
}
