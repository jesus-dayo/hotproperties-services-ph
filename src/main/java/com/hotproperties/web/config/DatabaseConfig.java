package com.hotproperties.web.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories(basePackages = "com.hotproperties.web.*.dao")
@EnableTransactionManagement
public class DatabaseConfig
{

	
}
