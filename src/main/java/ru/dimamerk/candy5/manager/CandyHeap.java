package ru.dimamerk.candy5.manager;

import ru.dimamerk.candy5.model.Candy;

public interface CandyHeap {

    void put(Candy candy);

    Candy get();

}
