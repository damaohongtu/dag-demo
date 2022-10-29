package com.mao.dag.mq.consumer;/**
 * @Classname KafkaConsumerService
 * @Description 消费者对producer产生的消息进行消费
 * @Date 19-5-9 下午4:05
 * @Created by mao<tianmao818@qq.com>
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestKafkaConsumerService {

    @KafkaListener(topics = "kafka_test_001", groupId = "sample-group", containerFactory = "kafkaListener")
    public void consume(String item){
        log.info(item);
    }
}
