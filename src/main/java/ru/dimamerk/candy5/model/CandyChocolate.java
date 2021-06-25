package ru.dimamerk.candy5.model;

public class CandyChocolate implements Candy {

    @Override
    public String getTitle() {
        return "Шоколадная";
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
