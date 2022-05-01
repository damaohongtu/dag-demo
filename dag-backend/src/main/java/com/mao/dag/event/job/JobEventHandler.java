package com.mao.dag.event.job;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobEventHandler {

    @Lazy
    @Autowired
    private JobEventHandler handler;

    @Subscribe
    @AllowConcurrentEvents
    public void subscribe(JobEvent event){
        handler.handle(event.toContext());
    }

    public void handle(JobContext context) {
        log.info("JobEventHandler handle, context={}", JSON.toJSONString(context));
    }

}
