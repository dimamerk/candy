package ru.dimamerk.candy5.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.dimamerk.candy5.model.CandyType;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

@Service
public class QueueService {
    private static final Logger LOGGER = LoggerFactory.getLogger(QueueService.class);

    private PriorityBlockingQueue<CandyType> queue;

    QueueService() {
        Comparator<CandyType> candyTypeComparator = Comparator.comparingInt(CandyType::getOrder);

        queue = new PriorityBlockingQueue<>(11, candyTypeComparator);
    }

    public void pushToQueue(CandyType candyType) {
        try {
            queue.add(candyType);
            LOGGER.info("Добавлена " + candyType.getTitle() + " конфета. Всего конфет: " + queue.size());
        } catch (Exception e) {
            LOGGER.error("Не удалось добавить конфету");
        }
    }

    public void logQueue() {
        try {
            while (!queue.isEmpty()) {
                System.out.println(queue.take());
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    public boolean queueIsEmpty() {
        return queue.isEmpty();
    }

    public CandyType queueTake() {
        try {
           return queue.take();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        return null;
    }
}
