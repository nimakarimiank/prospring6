package com.illuutech;

import java.util.ServiceLoader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String GREETING = "Hello ";

    public static void main(String[] args) {
        ServiceLoader<MessageRenderer> messageRendererServiceLoader = ServiceLoader.load(MessageRenderer.class);
        ServiceLoader<MessageProvider> messageProviderServiceLoader = ServiceLoader.load(MessageProvider.class);
        MessageRenderer mr = messageRendererServiceLoader.findFirst()
                .orElseThrow(()->new RuntimeException("Couldn't find a valid Implementation of class: "
                        + MessageRenderer.class.getName()));
        MessageProvider mp = messageProviderServiceLoader.findFirst()
                .orElseThrow(()->new RuntimeException("Couldn't find a valid Implementation of class: "
                        + MessageProvider.class.getName()));
        mr.setMessageProvider(mp);
        mr.render();
    }
}