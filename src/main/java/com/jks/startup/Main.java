package com.jks.startup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {

    public static void main(String...args) throws InterruptedException, ExecutionException {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MailSender mailSender = context.getBean(MailSender.class);
        System.out.println("about to run");

        Future sendFuture = mailSender.sendMail();
        System.out.println("this will run immediately - sender");


        Future receiveFuture = mailSender.receiveMail();
        System.out.println("this will run immediately - receiver");


        String msg = (String) receiveFuture.get();
        System.out.println("received mail: " + msg);
        Boolean result = (Boolean) sendFuture.get();
        System.out.println("mail send result: " + result);
    }
}
