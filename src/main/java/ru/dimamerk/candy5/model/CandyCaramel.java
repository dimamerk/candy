package ru.dimamerk.candy5.model;

public class CandyCaramel implements Candy {

    @Override
    public String getTitle() {
        return "Карамельная";
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
