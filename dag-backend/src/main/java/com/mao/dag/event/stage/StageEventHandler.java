package com.mao.dag.event.stage;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StageEventHandler {

//    @Lazy
//    @Autowired
//    private StageEventHandler handler;
//
//    @Subscribe
//    @AllowConcurrentEvents
//    public void subscribe(StageEvent event){
//        handler.handle(event.toContext());
//    }
//
//    public void handle(StageContext context) {
//        log.info("JobEventHandler handle, context={}", JSON.toJSONString(context));
//    }

}
