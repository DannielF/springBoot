package com.springboot.configuration;

import com.springboot.pojo.UserPojo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * We want to separate configuration from our actual services, controllers and components.
 */
@Component
@EnableConfigurationProperties(UserPojo.class)
@ConfigurationProperties(prefix = "value")
public class GeneralConfiguration {

   @NonNull
   private String name;

   @NonNull
    private String lastname;

    public GeneralConfiguration() {
        name = null;
        lastname = null;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(@NonNull String lastname) {
        this.lastname = lastname;
    }

    /**
     * Build a data source
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:testdb");
        dataSourceBuilder.username("test");
        dataSourceBuilder.password("");

        return dataSourceBuilder.build();
    }
}
