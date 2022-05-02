package com.mao.dag.service.config;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.mao.dag.dal.entity.Config;
import com.mao.dag.dal.entity.Register;
import com.mao.dag.dal.repo.ConfigRepo;
import com.mao.dag.dal.repo.RegisterRepo;
import com.mao.dag.model.config.ConfigRequest;
import com.mao.dag.model.config.Edge;
import com.mao.dag.model.config.Node;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Component
public class ConfigServiceAssist {

    @Resource
    private ConfigRepo configRepo;

    @Resource
    private RegisterRepo registerRepo;

    @Transactional(rollbackFor = Exception.class)
    public void persistConfig(ConfigRequest request) throws Exception {

        Register register = buildRegister(request);
        List<Config> configList = buildConfig(request);

        int insertRegister = registerRepo.insert(register);
        if(insertRegister <= 0){
            throw new Exception("插入登记记录失败");
        }

        for(Config config:configList){
            int insertConfig = configRepo.insert(config);
            if(insertConfig <= 0){
                throw new Exception("插入配置失败");
            }
        }
    }

    private Register buildRegister(ConfigRequest request){
        Register register = new Register();
        register.setBizCode(request.getBizCode());
        register.setBizName(request.getBizName());
        register.setEdges(JSON.toJSONString(request.getEdges()));
        register.setValid(1);
        return register;
    }

    private List<Config> buildConfig(ConfigRequest request){

        List<Node> nodes = request.getNodes();
        List<Edge> edges = request.getEdges();

        Map<Integer, List<Integer>> parentConfig = new HashMap<>();
        Map<Integer, List<Integer>> childConfig = new HashMap<>();
        for (Edge edge:edges){
            Integer sourceNode = edge.getSourceNode();
            Integer targetNode = edge.getTargetNode();
            parentConfig.computeIfAbsent(targetNode, key -> new ArrayList<>()).add(sourceNode);
            childConfig.computeIfAbsent(sourceNode, key-> new ArrayList<>()).add(targetNode);
        }

        List<Config> configList = new ArrayList<>();

        for (Node node : nodes){
            Config config = new Config();
            config.setBizCode(request.getBizCode());
            config.setConfigCode(node.getId());
            config.setProcessor(node.getProcessor());
            config.setConfigInfo(node.getConfigInfo());
            config.setChildCode(JSON.toJSONString(childConfig.get(node.getId())));
            config.setParentCode(JSON.toJSONString(parentConfig.get(node.getId())));
            config.setNodeLoc(JSON.toJSONString(Arrays.asList(node.getLeft(), node.getTop())));
            config.setValid(1);
            configList.add(config);
        }

        return configList;
    }
}
