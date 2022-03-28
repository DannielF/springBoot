package com.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentToImplement implements ComponentDependency{
    @Override
    public void greetings() {
        System.out.println("Greetings from Component 2");
    }
}
