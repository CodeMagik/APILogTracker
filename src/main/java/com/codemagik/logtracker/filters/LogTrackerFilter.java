package com.codemagik.logtracker.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class LogTrackerFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(LogTrackerFilter.class);

    @Override
    public void doFilter(ServletRequest httpServletRequest, ServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) httpServletRequest;

        //To track the current context for this service.
        String contextId = UUID.randomUUID().toString();
        MDC.put("contextId", contextId);

        //To track the client incoming request
        String trackingId = req.getHeader("Message-ID");
        if (trackingId != null && !trackingId.trim().isEmpty()) {
            MDC.put("requestId", trackingId);
        }

        //To track the request across different components.
        String traceId = req.getHeader("Trace-ID");
        if (traceId == null || traceId.trim().isEmpty()) {
            traceId = UUID.randomUUID().toString();
        }

        MDC.put("traceId", traceId);

        logger.info("Logging context settings completed");

        filterChain.doFilter(httpServletRequest, httpServletResponse);

        MDC.clear();
    }
}
