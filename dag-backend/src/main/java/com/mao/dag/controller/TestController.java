package com.mao.dag.controller;


import com.alibaba.fastjson.JSON;
import com.mao.dag.dal.entity.Register;
import com.mao.dag.dal.repo.RegisterRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
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

    @RequestMapping("/getConfig")
    public Register testScreenShot(@RequestParam Long id) {

        Register register = registerConfigRepo.getRegister(id);

        String item = JSON.toJSONString(register);

        kafkaTemplate.send("kafka_test", item);

        return register;
    }
}