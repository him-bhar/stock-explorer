package com.himanshu.stockpicker.stock_explorer.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.*;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DatabaseConfig {

  @Bean
  DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
          .generateUniqueName(true)
          .setType(EmbeddedDatabaseType.H2)
          .build();
  }

  @Bean
  SpringLiquibase liquibase(@Autowired DataSource dataSource,
                            @Value("${spring.liquibase.change-log}") String changeLog,
                            @Value("${spring.liquibase.contexts}") String contexts) {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setContexts(contexts);
    liquibase.setChangeLog(changeLog);
    liquibase.setDataSource(dataSource);
    return liquibase;
  }
}
