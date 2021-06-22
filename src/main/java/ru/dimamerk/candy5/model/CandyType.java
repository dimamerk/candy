package ru.dimamerk.candy5.model;

public enum CandyType {

    CHOCOLATE("Шоколадная", 1),
    CARAMEL("Карамельная", 2);

    private String title;
    private int order;

    CandyType(String title, int order) {
        this.title = title;
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "CandyType: { title: '" + title + "', order: '" + order + "'}";
    }

}
