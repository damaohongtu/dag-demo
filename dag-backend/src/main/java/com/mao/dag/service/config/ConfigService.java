package com.mao.dag.service.config;

import com.mao.dag.model.BaseResponse;
import com.mao.dag.model.config.ConfigRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ConfigService {

    @Resource
    private ConfigServiceAssist configServiceAssist;

    public BaseResponse createConfig(ConfigRequest request) {

        try {
            configServiceAssist.persistConfig(request);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;

    }
}
