package ru.dimamerk.candy5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.dimamerk.candy5.manager.CandyHeap;
import ru.dimamerk.candy5.manager.CandyHeapManager;
import ru.dimamerk.candy5.manager.CandyHeapManagerImpl;
import ru.dimamerk.candy5.manager.CandyHeapPriorityQueueImpl;

@Configuration
public class Candy5ApplicationConfiguration {

    @Value("${candy.eaters.count}")
    private int eatersCount;

    @Bean
    public CandyHeap candyHeap() {
        return new CandyHeapPriorityQueueImpl();
    }

    @Bean
    public CandyHeapManager candyHeapManager() {
        CandyHeapManagerImpl candyHeapManager = new CandyHeapManagerImpl();
        candyHeapManager.setCandyHeap(candyHeap());
        candyHeapManager.start(eatersCount);
        return candyHeapManager;
    }

}
