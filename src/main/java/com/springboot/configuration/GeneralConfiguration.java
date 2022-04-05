package com.springboot.configuration;

import com.springboot.pojo.UserPojo;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

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
}
