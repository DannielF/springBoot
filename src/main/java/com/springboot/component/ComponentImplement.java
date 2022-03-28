package com.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{

    @Override
    public void greetings() {
        System.out.println("Greetings");
    }
}
