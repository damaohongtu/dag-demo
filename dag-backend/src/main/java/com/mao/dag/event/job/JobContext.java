package com.mao.dag.event.job;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class JobContext {

    private Integer bizCode;

    private String jobNo;

    private Integer status;

}
