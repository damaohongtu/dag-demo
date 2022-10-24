package com.mao.dag.mq.message;

import lombok.Data;

import java.util.List;

/**
 * @Classname GraphDrivenMessage
 * @Description 驱动消息
 * @Date 2022-05-02 下午4:05
 * @Created by mao<tianmao818@qq.com>
 */

@Data
public class GraphDrivenMessage {

    /**
     * JOB配置编码
     */
    private Integer businessCode;

    /**
     * job流水号
     */
    private String jobNo;

    /**
     * STAGE配置编码
     */
    private List<Integer> configCodeList;

}


