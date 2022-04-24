package com.anti.springbootbase.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TimeTask {
    Logger LOG = LoggerFactory.getLogger(TimeTask.class.getName());
    private static final SimpleDateFormat format =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedDelay = 3000)
    public void systemDate() {
        LOG.info("当前时间::::" + format.format(new Date()));
    }

}
