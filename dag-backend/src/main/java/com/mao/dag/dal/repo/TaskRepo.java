package com.mao.dag.dal.repo;

import com.mao.dag.dal.dao.TaskMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class TaskRepo {
    @Resource
    private TaskMapper taskMapper;
}
