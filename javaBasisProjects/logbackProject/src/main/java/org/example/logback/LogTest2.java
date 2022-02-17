package org.example.logback;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dragon
 * @date 2021/12/31
 */
public class LogTest2 {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(LogTest2.class);
        logger.info("Entering application.");
        Thread.sleep(2000);

        logger.info("Exiting application.");

        logger.debug("hello debug");
    }
}
