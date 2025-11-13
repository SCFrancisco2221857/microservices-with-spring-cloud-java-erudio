package com.example.rest_with_spring_boot_and_java_erudio.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLoggingController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/test")
    public String testlog() {
        logger.debug("testlogDebug");
        logger.info("testlogInfo");
        logger.warn("testlogWarn");
        logger.error("testlogError");
        return "Hello World";
    }
}
