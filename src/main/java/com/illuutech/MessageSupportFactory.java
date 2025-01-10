package com.illuutech;

import java.util.Optional;
import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;
    private Properties properties;
    private MessageProvider messageProvider;
    private MessageRenderer messageRenderer;

    private MessageSupportFactory() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/message.properties"));
//            properties.load(MessageSupportFactory.class.getClassLoader().getResourceAsStream("message.properties"));
            String rendererClass = properties.getProperty("renderer.class");
            String providerClass = properties.getProperty("provider.class");
            messageProvider = (MessageProvider) Class.forName(rendererClass).getDeclaredConstructor().newInstance();
            messageRenderer = (MessageRenderer) Class.forName(providerClass).getDeclaredConstructor().newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }
    public static MessageSupportFactory getInstance() {
        return instance;
    }
    public Optional<MessageRenderer> getMessageRenderer() {
        return Optional.ofNullable(messageRenderer);
    }
}

