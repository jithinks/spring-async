package com.jks.startup;

import com.sun.xml.internal.ws.util.CompletedFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class MailSender {

    @Async
    public Future<Boolean> sendMail() throws InterruptedException{
        System.out.println("sending mail.." + Thread.currentThread().getName());
        Thread.sleep(1000 * 10);
        System.out.println("sending mail completed.." + Thread.currentThread().getName());
        return new AsyncResult<Boolean>(true);
    }

  /*  @Async("threadPoolTaskExecutor")
    public Future<String> receiveMail() throws InterruptedException{
        System.out.println("Receiving mail.."+ Thread.currentThread().getName());
       // Thread.sleep(500 * 10);
        System.out.println("mail received.."+ Thread.currentThread().getName());
        return new AsyncResult<String>("Hello.."+ Thread.currentThread().getName());
    }*/

    @Async
    public Future<String> receiveMail() throws InterruptedException{
        System.out.println("Receiving mail.."+ Thread.currentThread().getName());
        // Thread.sleep(500 * 10);
        System.out.println("mail received.."+ Thread.currentThread().getName());
        return new AsyncResult<String>("Hello.."+ Thread.currentThread().getName());
    }
}
