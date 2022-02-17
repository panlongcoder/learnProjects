package org.example.logback;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dragon
 * @date 2021/12/31
 */
public class LevelLogTest {

    public static void main(String[] args) {
        ch.qos.logback.classic.Logger logger =
                (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("org.example");
        logger.setLevel(Level.ERROR);

        Logger logger1 = LoggerFactory.getLogger(LevelLogTest.class);

        Logger logger2 = LoggerFactory.getLogger(LevelLogTest.class);
        logger1.info("info");

        logger1.error("error");


        System.out.println(logger1 == logger2);

    }
}
