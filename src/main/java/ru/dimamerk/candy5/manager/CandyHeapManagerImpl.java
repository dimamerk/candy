package ru.dimamerk.candy5.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.dimamerk.candy5.model.Candy;
import ru.dimamerk.candy5.model.Eater;

import java.util.concurrent.*;

public class CandyHeapManagerImpl implements CandyHeapManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandyHeapManagerImpl.class);

    private CandyHeap candyHeap;

    private boolean added;

    private int eatersCount;

    @Override
    public void setCandyHeap(CandyHeap candyHeap) {
        this.candyHeap = candyHeap;
    }

    @Override
    public void run() {
        LOGGER.info("Запуск пожирателей");
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(eatersCount);

        try {
            while (true) {
                if (executorService.getActiveCount() < eatersCount) {
                    Candy candy = candyHeap.get();
                    if (candy != null) {
                        added = true;
                        executorService.execute(new Eater(candy));
                    } else {
                        if (added) {
                            if (executorService.getActiveCount() == 0) {
                                LOGGER.info("Все конфеты съедены");
                                added = false;
                            }
                        }
                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            LOGGER.error("Главный поток прерван");
        }

        executorService.shutdown();
    }

    @Override
    public void start(int eatersCount) {
        this.eatersCount = eatersCount;
        new Thread(this, "Пожиратели").start();
    }

}
