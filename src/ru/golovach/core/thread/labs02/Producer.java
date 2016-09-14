package ru.golovach.core.thread.labs02;

/**
 * Created on 14.09.2016.
 * This class represents simple object who produce some
 * information per unit of time. In this case it's integer number.
 */
public class Producer implements Runnable{
    private int startValue;
    private final int period;
    private final SingleElementBuffer buffer;
    private String empty = "";

    public Producer(String empty, int startValue, int period, SingleElementBuffer buffer) {
        this.buffer = buffer;
        this.period = period;
        this.startValue = startValue;
        this.empty = empty;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println(empty + startValue + " producer");
                buffer.put(empty, startValue++);
                Thread.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopped.");
                break;
            }

        }
    }
}
