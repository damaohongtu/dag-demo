package com.mao.dag.controller;


import com.alibaba.fastjson.JSON;
import com.mao.dag.dal.entity.Register;
import com.mao.dag.dal.repo.RegisterRepo;
import com.mao.dag.model.BaseResponse;
import com.mao.dag.model.config.ConfigRequest;
import com.mao.dag.service.config.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private RegisterRepo registerConfigRepo;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Resource
    private ConfigService configService;

    @RequestMapping("/getConfig")
    public Register testScreenShot() {
        Long id = 1L;
        Register register = registerConfigRepo.getRegister(id);

        String item = JSON.toJSONString(register);

        kafkaTemplate.send("kafka_test_001", item);

        return register;
    }

    @RequestMapping("/createConfig")
    public BaseResponse createConfig(@RequestBody ConfigRequest request){
        return configService.createConfig(request);
    }
}