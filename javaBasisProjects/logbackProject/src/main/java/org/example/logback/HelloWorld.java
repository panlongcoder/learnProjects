package org.example.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dragon
 * @date 2021/12/31
 */
public class HelloWorld {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("org.example.logback.HelloWorld");
        logger.debug("Hello world.");
        Logger rootLogger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);

    }
}
