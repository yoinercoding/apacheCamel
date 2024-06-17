package com.apache.camel.microservices.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingProcessor implements Processor {

    private Logger logger = LoggerFactory.getLogger(Logging.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        logger.info("LoggingProcessor {}", exchange.getMessage().getBody());
    }
}