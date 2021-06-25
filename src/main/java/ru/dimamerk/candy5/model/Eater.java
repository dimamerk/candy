package ru.dimamerk.candy5.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Eater implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Eater.class);

    private Candy candy;

    public Eater(Candy candy) {
        this.candy = candy;
    }

    @Override
    public void run() {
        try {
            Random rand = new Random();
            int sleep = 500 + rand.nextInt(1000);
            LOGGER.info("Пожиратель #" + Thread.currentThread().getName() + " начал есть конфету #" + candy.hashCode() + ": " + candy.getTitle());
            Thread.sleep(sleep);
            LOGGER.info("Пожиратель #" + Thread.currentThread().getName() + " доел конфету #" + candy.hashCode() + ": " + candy.getTitle() + ", за " + sleep + " мс.");
        } catch (InterruptedException e) {
            LOGGER.error("Поток прерван");
        }
    }

}
