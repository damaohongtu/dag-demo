package com.mao.dag.dal.dao;

import com.mao.dag.dal.entity.Stage;
import java.util.List;

public interface StageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Stage record);

    Stage selectByPrimaryKey(Long id);

    List<Stage> selectAll();

    int updateByPrimaryKey(Stage record);
}