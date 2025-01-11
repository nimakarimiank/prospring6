package com.illuutech;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public MessageProvider messageProvider() {
        return new MessageProviderImpl();
    }

    @Bean
    public MessageRenderer messageRenderer() {
        MessageRenderer mr = new MessageRendererImpl();
        mr.setMessageProvider(this.messageProvider());
        return mr;

    }
}
