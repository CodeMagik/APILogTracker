package com.codemagik.logtracker.controller;

import com.codemagik.logtracker.filters.LogTrackerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(LogTrackerFilter.class);

    @RequestMapping("/hello")
    public ResponseEntity<String> hello() {

        logger.info("INFO log - Hello API called");
        logger.warn("WARN log - Hello API called");
        logger.error("ERROR log - Hello API called");

        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }
}
