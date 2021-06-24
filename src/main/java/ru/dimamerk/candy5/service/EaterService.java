package ru.dimamerk.candy5.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dimamerk.candy5.model.CandyType;
import ru.dimamerk.candy5.model.Eater;

@Service
public class EaterService implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(EaterService.class);

    private static final int EATER_COUNT = 5;

    QueueService queueService;

    Eater[] eaters = new Eater[EATER_COUNT];

    @Autowired
    public EaterService(QueueService queueService) {
        this.queueService = queueService;
        for (int i = 0; i < eaters.length; i++) {
            eaters[i] = new Eater("Пожиратель #" + (i + 1));
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!queueService.queueIsEmpty()) {
                    for (Eater eater: eaters) {
                        if (!eater.isRunning()) {
                            CandyType candyType = queueService.queueTake();
                            eater.eatCandy(candyType);
                            break;
                        }
                    }
                } else {
                    if (queueService.isAdded()) {
                        boolean allFinished = true;
                        for (Eater eater: eaters) {
                            if (eater.isRunning()) {
                                allFinished = false;
                                break;
                            }
                        }
                        if (allFinished) {
                            LOGGER.info("Пожиратели съели все конфеты");
                            queueService.setAdded(false);
                        }
                    }
                }
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            LOGGER.error("Поток прерван");
        }
    }

    public void start() {
        LOGGER.info("Запуск пожирателей");
        new Thread(this, "Сервис пожирателей").start();
    }

}
