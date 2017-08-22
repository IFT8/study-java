package cn.assupg.study.study09;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Asynchronous implements Runnable {

    @Async
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                System.out.println("===============" + i);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
