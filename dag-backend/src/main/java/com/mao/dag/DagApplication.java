package com.mao.dag;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.mao.dag.dal.dao")
public class DagApplication {

	public static void main(String[] args) {
		SpringApplication.run(DagApplication.class, args);
	}

}
