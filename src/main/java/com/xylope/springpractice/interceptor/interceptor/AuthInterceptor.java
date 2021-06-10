package com.xylope.springpractice.interceptor.interceptor;

import com.xylope.springpractice.interceptor.annotation.Auth;
import com.xylope.springpractice.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(url)
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url : {}", url);

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);

        //my server is run public default
        //but if request has Auth permission,
        if(hasAnnotation) {
            String query = uri.getQuery();
            log.info("query : {}", query);
            if(query.equals("name=steve")) return true;
            else throw new AuthException("유저의 이름이 steve 가 아닙니다");
        }

        return checkIsResource(handler);
    }

    private boolean checkIsResource(Object handler) {
        return handler instanceof ResourceHttpRequestHandler;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {
        HandlerMethod method = (HandlerMethod) handler;
        return method.getMethodAnnotation(clazz) != null || method.getBeanType().getAnnotation(clazz) != null;
    }
}
