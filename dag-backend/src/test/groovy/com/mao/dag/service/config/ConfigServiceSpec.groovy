package com.mao.dag.service.config

import com.mao.dag.model.BaseResponse
import com.mao.dag.model.config.ConfigRequest
import spock.lang.Specification

class ConfigServiceSpec extends Specification{

    ConfigService configService = new ConfigService()
    ConfigServiceAssist configServiceAssist = Mock()

    def setup(){
        configService.configServiceAssist = configServiceAssist
    }

    def "Test createConfigService"(){
        given:
        ConfigRequest request = new ConfigRequest()
        and:
        configServiceAssist.persistConfig(_) >> null
        when:
        BaseResponse response = configService.createConfig(request)
        then:
        response.getStatus() == 200

    }


}
