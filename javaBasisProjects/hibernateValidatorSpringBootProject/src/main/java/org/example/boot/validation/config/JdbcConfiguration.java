package org.example.boot.validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author dragon
 * @date 2021/11/20
 */
@Configuration
public class JdbcConfiguration {


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
         return new JdbcTemplate(dataSource);
    }
}
