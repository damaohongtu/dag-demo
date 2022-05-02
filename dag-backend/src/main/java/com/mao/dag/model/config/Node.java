package com.mao.dag.model.config;

import lombok.Data;

@Data
public class Node {

    private Integer id;

    private Integer left;

    private Integer top;

    private String processor;

    private String configInfo;
}
