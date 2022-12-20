package ru.rzd;

import org.apache.camel.spring.Main;


public class MyApp {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.setApplicationContextUri("META-INF/spring/camel-context.xml");

        System.out.println("Start camel context");

        main.run();
    }

}
