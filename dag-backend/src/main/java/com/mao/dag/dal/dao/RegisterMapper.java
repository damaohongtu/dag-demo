package com.mao.dag.dal.dao;

import com.mao.dag.dal.entity.Register;
import java.util.List;

public interface RegisterMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Register record);

    Register selectByPrimaryKey(Long id);

    List<Register> selectAll();

    int updateByPrimaryKey(Register record);
}