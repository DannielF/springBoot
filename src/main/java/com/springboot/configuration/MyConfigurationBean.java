package com.springboot.configuration;

import com.springboot.bean.MyBean;
import com.springboot.bean.MyBeanImplement;
import com.springboot.bean.MyBeanWithDependency;
import com.springboot.bean.MyBeanWithDependencyImplement;
import com.springboot.bean.MyOperation;
import com.springboot.bean.MyOperationImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    /**
     * Creating a first bean
     * @return void
     */
    @Bean
    public MyBean beanOperation() {
        return new MyBeanImplement();
    }

    @Bean
    public MyOperation myOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency myOperationImplement(MyOperation myOperation) {
        return new MyBeanWithDependencyImplement(myOperation);
    }
}
