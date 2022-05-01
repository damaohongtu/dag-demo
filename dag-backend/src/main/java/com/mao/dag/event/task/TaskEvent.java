package com.mao.dag.event.task;

public class TaskEvent {

    public TaskContext toContext(){
        return TaskContext.builder().build();
    }
}
