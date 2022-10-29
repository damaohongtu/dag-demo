package com.mao.dag.service.config;

import com.mao.dag.model.BaseResponse;
import com.mao.dag.model.config.ConfigRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class ConfigService {

    @Resource
    private ConfigServiceAssist configServiceAssist;

    public BaseResponse createConfig(ConfigRequest request) {

        BaseResponse response = new BaseResponse();

        try {
            configServiceAssist.persistConfig(request);
        } catch (Exception e) {
            log.error("createConfig error, e=", e);
        }

        response.setStatus(200);
        return response;

    }
}
