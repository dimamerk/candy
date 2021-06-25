package ru.dimamerk.candy5.manager;

public interface CandyHeapManager extends Runnable {

    void start(int eatersCount);

    void setCandyHeap(CandyHeap candyHeap);

}
