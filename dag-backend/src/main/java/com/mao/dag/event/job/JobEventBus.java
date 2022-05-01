package com.mao.dag.event.job;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.EventBus;
import com.mao.dag.constant.EventBusConstant;
import com.mao.dag.util.EventBusManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Slf4j
@Component
public class JobEventBus {

    @Resource(name = "jobEventExecutor")
    private ThreadPoolTaskExecutor executor;

    @Resource
    private JobEventHandler jobEventHandler;

    private EventBus eventBus;

    @PostConstruct
    public void init(){
        this.eventBus = EventBusManager.getAsyncEventBus(EventBusConstant.JOB_EVENT_BUS, executor);
        this.eventBus.register(jobEventHandler);
    }

    public void postAsync(Object event){
        if(event == null){
            return;
        }
        this.eventBus.post(event);
        log.info("event={}", JSON.toJSONString(event));
    }
}
