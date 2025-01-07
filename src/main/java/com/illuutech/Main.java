package com.illuutech;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String GREETING = "Hello ";

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(GREETING + args[0]);
        } else {
            System.out.println(GREETING + "anonymous!");
        }
    }
}