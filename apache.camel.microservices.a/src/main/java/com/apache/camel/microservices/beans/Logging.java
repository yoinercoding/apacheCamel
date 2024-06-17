package com.apache.camel.microservices.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Logging {

    private Logger logger = LoggerFactory.getLogger(Logging.class);

    public void process(String message) {
        logger.info("Logging {}" , message);
    }
}
