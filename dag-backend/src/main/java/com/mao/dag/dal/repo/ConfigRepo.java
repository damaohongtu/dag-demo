package com.mao.dag.dal.repo;

import com.mao.dag.dal.dao.ConfigMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ConfigRepo {
    @Resource
    private ConfigMapper configMapper;
}
