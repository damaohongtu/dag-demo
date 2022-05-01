package com.mao.dag.event.task;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class TaskContext {

    private Integer bizCode;

    private String jobNo;

    private Integer status;

}
