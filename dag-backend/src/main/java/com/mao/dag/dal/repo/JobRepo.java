package com.mao.dag.dal.repo;

import com.mao.dag.dal.dao.JobMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class JobRepo {
    @Resource
    private JobMapper jobMapper;
}
