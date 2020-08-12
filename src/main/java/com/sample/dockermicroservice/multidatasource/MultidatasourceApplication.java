package com.sample.dockermicroservice.multidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.sample.dockermicroservice.multidatasource.user")
@EnableMongoRepositories(basePackages="com.sample.dockermicroservice.multidatasource.product")
public class MultidatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultidatasourceApplication.class, args);
	}

}
