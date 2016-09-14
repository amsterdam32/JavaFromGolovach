package ru.golovach.core.thread.labs02;

/**
 * Created on 14.09.2016.
 * This class represents the simple version Buffer
 * with Single Element.
 */
public class SingleElementBuffer {
    private Integer elem = null;
    private String empty = null;

    public synchronized void put(String empty, Integer newElem) throws InterruptedException {
        while (elem != null) {
            this.wait();
            if (elem != null) {
                this.notify();
            }
        }
        this.elem = newElem;
        this.empty = empty;
        this.notify();
    }

    public synchronized Integer get() throws InterruptedException {
        while (elem == null) {
            this.wait();
            if (elem == null) {
                this.notify();
            }
        }
        int result = this.elem;
        this.elem = null;
        this.notify();
        return result;
    }

    public synchronized String getEmpty() throws InterruptedException {
        while (empty == null) {
            this.wait();
            if (empty == null) {
                this.notify();
            }
        }
        String result = this.empty;
        this.empty = null;
        this.notify();
        return result;
    }


}
