package ru.golovach.core.thread.labs02;

/**
 * Created on 14.09.2016.
 * This class represents simple object who can consume
 * information how it be available. In this case it's integer number.
 */
public class Consumer implements Runnable{
    private final int id;
    private final SingleElementBuffer buffer;
    private String empty = "";

    public Consumer(int id, SingleElementBuffer buffer) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            Integer elem = null;
            try {
                elem = buffer.get();
                this.empty = buffer.getEmpty();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(empty + elem + " consumed by " + id);

        }
    }
}
