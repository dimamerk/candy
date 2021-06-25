package ru.dimamerk.candy5.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.dimamerk.candy5.model.Candy;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class CandyHeapPriorityQueueImpl implements CandyHeap {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandyHeapPriorityQueueImpl.class);

    private PriorityBlockingQueue<Candy> queue;

    public CandyHeapPriorityQueueImpl() {
        Comparator<Candy> candyTypeComparator = Comparator.comparingInt(Candy::getOrder);
        queue = new PriorityBlockingQueue<>(11, candyTypeComparator);
    }

    @Override
    public void put(Candy candy) {
        queue.add(candy);
        LOGGER.info("Добавлена " + candy.getTitle() + " конфета #" + candy.hashCode() + ". Всего конфет: " + queue.size());
    }

    @Override
    public Candy get() {
        return queue.poll();
    }

}
