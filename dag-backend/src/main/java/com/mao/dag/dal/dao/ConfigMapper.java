package com.mao.dag.dal.dao;

import com.mao.dag.dal.entity.Config;
import java.util.List;

public interface ConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Config record);

    Config selectByPrimaryKey(Long id);

    List<Config> selectAll();

    int updateByPrimaryKey(Config record);
}