package ru.golovach.core.thread.labs02;

import java.util.concurrent.TimeUnit;

/**
 * Created by Wladimir on 13.09.2016.
 * Demonstration work unlimited number producers and consumers
 * through buffer containing single element.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer("", 100, 300, buffer)).start();
        new Thread(new Producer("----", 200, 500, buffer)).start();
        new Thread(new Producer("========", 300, 700, buffer)).start();

        new Thread(new Consumer(1, buffer)).start();
        new Thread(new Consumer(2, buffer)).start();
    }
}
