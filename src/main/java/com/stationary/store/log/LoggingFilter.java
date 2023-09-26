package com.stationary.store.log;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);


    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
        try {
            return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
    	createTraceId(request);
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();
        String requestBody = getStringValue(requestWrapper.getContentAsByteArray(),
                request.getCharacterEncoding());
        LOGGER.info(
                "PROCESSING : TraceId={}; METHOD={}; REQUESTURI={}; REQUEST PAYLOAD={}",
                ThreadContext.get("traceid"), request.getMethod(), request.getRequestURI(), requestBody);
        filterChain.doFilter(requestWrapper, responseWrapper);
        long timeTaken = System.currentTimeMillis() - startTime;

        
        String responseBody = getStringValue(responseWrapper.getContentAsByteArray(),
                response.getCharacterEncoding());

        LOGGER.info(
                "FINISHED PROCESSING : TraceId={}; METHOD={}; REQUESTURI={}; REQUEST PAYLOAD={}; RESPONSE CODE={}; RESPONSE={}; TIM TAKEN={}",
                ThreadContext.get("traceid"), request.getMethod(), request.getRequestURI(), requestBody, response.getStatus(), responseBody,
                timeTaken);
        responseWrapper.copyBodyToResponse();
    }
    
    /**
     * Creates request traceid
     */
    private void createTraceId(HttpServletRequest request) {
    	String traceid = request.getHeader("traceid");
    	if(traceid == null || "".equals(traceid)) {
    		traceid = Thread.currentThread().getId()+""+new Date().getTime();
    	}
    	ThreadContext.put("traceid", traceid); 
    }

}

