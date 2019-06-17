package com.microblog.gateway.config.swagger;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: top-parent
 * @description:
 * @author: Mr.lgj
 * @version:
 * @See:
 * @create: 2018-11-19 14:47
 **/
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
      //  resources.add(swaggerResource("用户权限系统", "/server-api/v2/api-docs", "2.0"));
      //  resources.add(swaggerResource("网关中心", "/", "2.0"));
      //  resources.add(swaggerResource("用户权限服务提供系统", "/security-provider-api/v2/api-docs", "2.0"));
      //  resources.add(swaggerResource("任务调度模块", "/points-quartz-api/v2/api-docs", "2.0"));
        resources.add(swaggerResource("私信模块", "/chat/v2/api-docs", "2.0"));
        resources.add(swaggerResource("用户模块", "/user/v2/api-docs", "2.0"));
        resources.add(swaggerResource("网关模块", "/v2/api-docs", "2.0"));
        resources.add(swaggerResource("微博模块", "/blog/v2/api-docs", "2.0"));
        resources.add(swaggerResource("任务调度模块", "/points/v2/api-docs", "2.0"));
        resources.add(swaggerResource("搜索模块", "/search/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}

