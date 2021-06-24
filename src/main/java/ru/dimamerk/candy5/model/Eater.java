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
            int sleep = 500 + rand.nextInt(1000);
            LOGGER.info(title + " начал есть конфету: " + candyType.getTitle());
            Thread.sleep(sleep);
            LOGGER.info(title + " доел конфету: " + candyType.getTitle() + ", за " + sleep + " мс.");
        } catch (InterruptedException e) {
            LOGGER.error("Поток прерван");
        }

        running = false;
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
