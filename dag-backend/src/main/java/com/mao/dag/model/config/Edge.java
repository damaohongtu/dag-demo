package com.mao.dag.model.config;

import lombok.Data;

@Data
public class Edge {

    private String id;

    private Integer sourceNode;

    private Integer targetNode;

    private String source;

    private String target;

}
