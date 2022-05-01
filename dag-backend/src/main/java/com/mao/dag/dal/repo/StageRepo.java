package com.mao.dag.dal.repo;

import com.mao.dag.dal.dao.StageMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class StageRepo {

    @Resource
    private StageMapper stageMapper;

}
