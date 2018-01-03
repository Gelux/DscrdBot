/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personaljes.dscrdbot;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;

/**
 *
 * @author Jes
 */
public class Log {

    private static Logger logger;
    
    Log(){
        init();
    }

    public static void error(String msg) {
        logger.error(msg);
    }

    public static void warn(String msg) {
        logger.warn(msg);
    }

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void debug(String msg) {
        logger.debug(msg);
    }

    public static void debug(String format, Object... argArray) {
        logger.debug(format, argArray);
    }

    static void init() {
        if (logger != null) {
            return;
        }
        // Setup bot logger
        setupOwnLogger();
        // Print first log message
        Log.debug("Logger initialized.");
    }

    private static void setupOwnLogger() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        System.out.println(lc);
        logger = (Logger) LoggerFactory.getLogger("BotApp");
        System.out.println(logger);
        ConsoleAppender<ILoggingEvent> ca = new ConsoleAppender<ILoggingEvent>();
        ca.setContext(lc);
        ca.setName("console");
        LayoutWrappingEncoder<ILoggingEvent> encoder = new LayoutWrappingEncoder<>();

        PatternLayout layout = new PatternLayout();
        layout.setPattern("[%d{HH:mm:ss}] [%level] [%logger] %msg%n");
        layout.setContext(lc);
        layout.start();
        encoder.setLayout(layout);

        ca.setEncoder(encoder);
        ca.start();

//         disable default appender
        logger.setAdditive(false);

//         enable custom console appender
        logger.addAppender(ca);

//         set logging level
        
        logger.setLevel(Level.INFO);
        
    }
}
