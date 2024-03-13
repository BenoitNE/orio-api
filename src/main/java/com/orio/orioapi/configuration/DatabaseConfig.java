package com.orio.orioapi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseConfig(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("/data.sql"));

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);


        if (!isDatabaseInitialized()) {
            dataSourceInitializer.setEnabled(true);
        } else {
            dataSourceInitializer.setEnabled(false);
        }

        return dataSourceInitializer;
    }

    private boolean isDatabaseInitialized() {
        try {
            jdbcTemplate.queryForObject("SELECT id FROM job_description LIMIT 1", Long.class);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
