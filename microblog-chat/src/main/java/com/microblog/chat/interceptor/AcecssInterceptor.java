package com.microblog.chat.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
@Slf4j
public class AcecssInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.debug("AcecssInterceptor  preHandle");
        Cookie[] cookies  = request.getCookies();
        if(cookies == null){
            log.debug("cookies is null");
        }

        else{
            for(Cookie cookie : cookies){
                log.debug("cookie = " + cookie.getValue());
            }
        }
        return true;
    }
}
