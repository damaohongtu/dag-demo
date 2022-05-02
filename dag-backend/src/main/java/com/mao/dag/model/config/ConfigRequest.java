package com.mao.dag.model.config;

import com.mao.dag.dal.entity.Register;
import lombok.Data;

import java.util.List;

@Data
public class ConfigRequest {

    private Integer bizCode;

    private String bizName;

    private List<Node> nodes;

    private List<Edge> edges;

}
