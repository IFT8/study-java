package cn.assupg.study;


import com.comodin.basic.util.RedisUtils;

import java.util.Random;
import java.util.UUID;

public class Main {

    //调度主程序
    public static void main(String[] args) throws InterruptedException {

        // 启动一个生产者线程，模拟任务的产生
        new Thread(new TaskProducer()).start();

        Thread.sleep(15000);

        //启动一个线程者线程，模拟任务的处理
        new Thread(new TaskConsumer()).start();

        //主线程休眠
        Thread.sleep(Long.MAX_VALUE);

    }

    //生产者模拟程序
    public static class TaskProducer implements Runnable {
        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                try {
                    Thread.sleep(random.nextInt(600) + 600);
                    // 模拟生成一个任务
                    UUID taskid = UUID.randomUUID();
                    //将任务插入任务队列：task-queue
                    RedisUtils.lpush("task-queue", taskid.toString());
                    System.out.println("插入了一个新的任务： " + taskid);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //消费者模拟程序
    public static class TaskConsumer implements Runnable {

        @Override
        public void run() {
            Random random = new Random();

            while (true) {

                //从任务队列"task-queue"中获取一个任务，并将该任务放入暂存队列"tmp-queue"
                String taskid = RedisUtils.rpoplpush("task-queue", "tmp-queue");


                // 处理任务----纯属业务逻辑，模拟一下：睡觉
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                //模拟成功和失败的偶然现象
                if (random.nextInt(13) % 7 == 0) {// 模拟失败的情况,概率为2/13
                    //将本次处理失败的任务从暂存队列"tmp-queue"中，弹回任务队列"task-queue"
                    RedisUtils.rpoplpush("tmp-queue", "task-queue");
                    System.out.println(taskid + "处理失败，被弹回任务队列");

                } else {// 模拟成功的情况

                    // 将本次任务从暂存队列"tmp-queue"中清除
                    RedisUtils.rpop("tmp-queue");
                    System.out.println(taskid + "处理成功，被清除");

                }
            }
        }
    }
}
