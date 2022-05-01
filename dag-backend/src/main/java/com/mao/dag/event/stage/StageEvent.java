package com.mao.dag.event.stage;

public class StageEvent {

    public StageContext toContext(){
        return StageContext.builder().build();
    }
}
