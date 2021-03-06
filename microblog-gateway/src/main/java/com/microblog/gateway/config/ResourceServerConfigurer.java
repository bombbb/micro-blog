package com.microblog.gateway.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Steven on 2019/10/27.
 */
@Configuration
@Slf4j
@EnableWebFluxSecurity
public class ResourceServerConfigurer {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private SecurityWebFilterChain securityWebFilterChain;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {



        /*
        Refused to display 'http://localhost:8081/api/auth/druid/index.html' in a frame because it set 'X-Frame-Options' to 'deny'.
        * */
        http.headers().frameOptions().mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);
        http.oauth2ResourceServer().jwt();
        http
            .csrf().disable()
            .authorizeExchange()
            .pathMatchers(

                    "/",
                    "/api/auth/**",
                    "/actuator/**",
                    "/api/gateway/eureka/**",
                    "/api/swagger/**",
                    "/api/gateway/swagger-ui.html/**","/api/gateway/swagger-ui.html","/api/gateway/webjars/**",
                    "/api/gateway/swagger-resources/**","/api/gateway/swagger-ui./**",
                    "/api/gateway/v2/**","/api/gateway/api/gateway/v2/**",
                    "/swagger-ui.html/**","/swagger-ui.html","/webjars/**",
                    "/swagger-resources/**","/swagger-ui./**","/favicon.ico",
                    "/v2/**","/api/gateway/v2/**"
                    ).permitAll()

            .pathMatchers("/api/needauth").authenticated()
            .pathMatchers("/api/notauth")
            .access(AccessReactiveAuthorizationManager.hasAnyAuthority("USER1","ADMIN1"))//hasAnyRole("USER"," ADMIN")
            //.pathMatchers("/api/notauth").hasAnyRole("USER"," ADMIN")
            .anyExchange().authenticated()
              //  .and().authenticationManager()
            .and()
            .exceptionHandling().accessDeniedHandler(
                new ServerAccessDeniedHandler() {
                    @Override
                        public Mono<Void> handle(ServerWebExchange serverWebExchange, AccessDeniedException e) {

                            e.printStackTrace();
                            return Mono.empty();
                        }
                    })
        ;
        SecurityWebFilterChain chain = http.build();
//        Iterator<WebFilter> weIterable = chain.getWebFilters().toIterable().iterator();
//        while(weIterable.hasNext()) {
//            WebFilter f = weIterable.next();
//            if(f instanceof AuthenticationWebFilter) {
//                AuthenticationWebFilter webFilter = (AuthenticationWebFilter) f;
//                //将自定义的AuthenticationConverter添加到过滤器中
//                log.info("将自定义的AuthenticationConverter添加到过滤器中");
//                //webFilter.setServerAuthenticationConverter(new AuthenticationConverter());
//            }
//        }



        Flux<WebFilter> webFilterFlux =  chain.getWebFilters();

        Flux<WebFilter>  filter =  webFilterFlux.filter( webFilter -> {


            return true;
        });





        return chain;


    }

    //------------------------------------------------------------------
//    @Bean
//    public ReactiveAuthenticationManager reactiveAuthenticationManager() {
//        return new ReactiveAuthenticationManagerAdapter((authentication)->{
//
//
//            log.info("ReactiveAuthenticationManager...");
//            if(authentication instanceof AccountAuthentication) {
//                AccountAuthentication gmAccountAuthentication = (AccountAuthentication) authentication;
//                if(gmAccountAuthentication.getPrincipal() != null) {
//                    authentication.setAuthenticated(true);
//                    return authentication;
//                } else {
//                    return authentication;
//                }
//            } else {
//                return authentication;
//            }
//        });
//    }


}

