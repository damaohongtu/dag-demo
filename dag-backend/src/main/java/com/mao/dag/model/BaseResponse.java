package com.mao.dag.model;

import lombok.Data;

@Data
public class BaseResponse<T> {

    private Integer status;

    private String message;

    private T data;
}
