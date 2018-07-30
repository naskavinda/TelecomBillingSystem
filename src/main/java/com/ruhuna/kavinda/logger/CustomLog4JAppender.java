package com.ruhuna.kavinda.logger;

import org.apache.log4j.Layout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.ErrorCode;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 7/30/2018
 */
public class CustomLog4JAppender extends RollingFileAppender {
    public CustomLog4JAppender() {
    }

    public CustomLog4JAppender(Layout layout, String filename,
                               boolean append) throws IOException {
        super(layout, filename, append);
    }

    public CustomLog4JAppender(Layout layout, String filename)
            throws IOException {
        super(layout, filename);
    }

    public void activateOptions() {
        if (fileName != null) {
            try {
                fileName = getNewLogFileName();
                setFile(fileName, fileAppend, bufferedIO, bufferSize);
            } catch (Exception e) {
                errorHandler.error("Error while activating log options", e,
                        ErrorCode.FILE_OPEN_FAILURE);
            }
        }
    }

    private String getNewLogFileName() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        if (fileName != null) {
            final String DOT = ".";
            final String hyphen = "-";
            final File currentLogFile = new File(fileName);
            final String currentLogFileName = currentLogFile.getName();
            String newLogFileName = currentLogFileName;

            final int dotIndex = currentLogFileName.indexOf(DOT);
            String projectName = "TelecomBillingSystem";
            if (dotIndex != -1) {
                // the file name has an extension. so, insert the time stamp
                // between the file name and the extension
                newLogFileName = projectName + hyphen + currentLogFileName.substring(0, dotIndex) + hyphen
                        + df.format(new Date()) + DOT
                        + currentLogFileName.substring(dotIndex + 1);
            } else {
                // the file name has no extension. So, just append the timestamp
                // at the end.
                newLogFileName = currentLogFileName + hyphen + System.currentTimeMillis();
            }
            return currentLogFile.getParent() + File.separator + projectName + File.separator + newLogFileName;
        }
        return null;
    }
}
