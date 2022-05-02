package com.mao.dag.event.task;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaskEventHandler {

//    @Lazy
//    @Autowired
//    private TaskEventHandler handler;
//
//    @Subscribe
//    @AllowConcurrentEvents
//    public void subscribe(TaskEvent event){
//        handler.handle(event.toContext());
//    }
//
//    public void handle(TaskContext context) {
//        log.info("JobEventHandler handle, context={}", JSON.toJSONString(context));
//    }

}
