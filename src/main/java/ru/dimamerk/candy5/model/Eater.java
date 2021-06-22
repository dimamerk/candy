package ru.dimamerk.candy5.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Eater implements Runnable{

    private static final Logger LOGGER = LoggerFactory.getLogger(Eater.class);

    private CandyType candyType;

    private String title;

    private boolean running = false;

    public Eater(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        try {
            Random rand = new Random();
            int sleep = 2500 + rand.nextInt(2500);
            LOGGER.info(title + " ест конфету: " + candyType.getTitle() + ", за " + sleep + " мс.");
            Thread.sleep(sleep);
            running = false;
        } catch (InterruptedException e) {
            LOGGER.error("Поток прерван");
        }
    }

    public boolean isRunning() {
        return running;
    }

    public boolean eatCandy(CandyType candyType) {
        if (!running) {
            running = true;
            this.candyType = candyType;
            new Thread(this, title).start();
            return true;
        }
        return false;
    }
}
