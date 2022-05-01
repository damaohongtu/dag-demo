package com.mao.dag.event.job;

public class JobEvent {

    public JobContext toContext(){
        return JobContext.builder().build();
    }
}
