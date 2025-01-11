package com.illuutech;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String GREETING = "Hello ";

    public static void main(String[] args) {
        //integrating Spring-context and ApplicationContext to implement IOC and DI in java
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring/application-context.xml");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        MessageProvider mp = ctx.getBean("provider", MessageProvider.class);
        mr.setMessageProvider(mp);
        mr.render();
        //
    }
}