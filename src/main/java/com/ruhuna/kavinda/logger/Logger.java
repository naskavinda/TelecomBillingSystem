package com.ruhuna.kavinda.logger;

import org.slf4j.LoggerFactory;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/30/2018
 */
public class Logger {
    public static void logInfoMessage(Object source, String s) {
        LoggerFactory.getLogger(toClass(source)).info(s);
    }

    public static void logDebugMessage(Object source, String s) {
        LoggerFactory.getLogger(toClass(source)).debug(s);
    }

    public static void logWarnMessage(Object source, String s) {
        LoggerFactory.getLogger(toClass(source)).warn(s);
    }

    public static void logErrorMessage(Object source, String s) {
        LoggerFactory.getLogger(toClass(source)).error(s);
    }

    public static void logTraceMessage(Object source, String s) {
        LoggerFactory.getLogger(toClass(source)).trace(s);
    }

    public static void logInfoMessage(Object source, Throwable e) {
        LoggerFactory.getLogger(toClass(source)).info(e.getMessage(), e);
    }

    public static void logDebugMessage(Object source, Throwable e) {
        LoggerFactory.getLogger(toClass(source)).debug(e.getMessage(), e);
    }

    public static void logWarnMessage(Object source, Throwable e) {
        LoggerFactory.getLogger(toClass(source)).warn(e.getMessage(), e);
    }

    public static void logErrorMessage(Object source, Throwable e) {
        LoggerFactory.getLogger(toClass(source)).error(e.getMessage(), e);
    }

    public static void logTraceMessage(Object source, Throwable e) {
        LoggerFactory.getLogger(toClass(source)).trace(e.getMessage(), e);
    }

    private static Class toClass(Object source) {
        if (source instanceof Class) {
            return (Class) source;
        } else {
            return source.getClass();
        }
    }
}
