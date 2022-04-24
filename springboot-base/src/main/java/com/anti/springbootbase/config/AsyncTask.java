package com.anti.springbootbase.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public void asyncTask0() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("======异步任务结束0======");
    }

    @Async("asyncExecutor1")
    public void asyncTask1() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("======异步任务结束1======");
    }


}
