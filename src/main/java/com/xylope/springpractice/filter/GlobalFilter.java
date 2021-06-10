package com.xylope.springpractice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/api/user/*")
public class GlobalFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter) throws IOException, ServletException {
        ContentCachingRequestWrapper httpReq = new ContentCachingRequestWrapper((HttpServletRequest)req);
        ContentCachingResponseWrapper httpRes = new ContentCachingResponseWrapper((HttpServletResponse) res);

        String url = httpReq.getRequestURI();
        filter.doFilter(httpReq, httpRes); //해당 메서드의 실행을 기준으로 전처리와 후처리로 나눈다.

        //log Request
        String reqContent = new String(httpReq.getContentAsByteArray());

        log.info("request url : {} \n========request body======== \n{}", url, reqContent);

        //log Response
        String resContent = new String(httpRes.getContentAsByteArray());
        int httpStatus = httpRes.getStatus();

        httpRes.copyBodyToResponse();

        log.info("response status : {} \n========response body======== \n{}", httpStatus, resContent);
    }
}
