package com.mao.dag.dal.repo;

import com.mao.dag.dal.dao.RegisterMapper;
import com.mao.dag.dal.entity.Register;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RegisterRepo {

    @Resource
    private RegisterMapper registerMapper;

    public Register getRegister(Long id){
        return registerMapper.selectByPrimaryKey(id);
    }

}
