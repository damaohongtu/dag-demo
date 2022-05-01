package com.mao.dag.event.stage;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class StageContext {

    private Integer bizCode;

    private String jobNo;

    private Integer status;

}
