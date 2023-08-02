package com.nemogz.CounterApp.services;

import com.nemogz.CounterApp.databaseobjects.Counter;
import com.nemogz.CounterApp.databaseobjects.User;
import com.nemogz.CounterApp.repository.CounterRepository;
import org.springframework.stereotype.Service;

@Service
public class CounterService {

    private final CounterRepository repository;

    public CounterService(CounterRepository repository) {
        this.repository = repository;
    }

    public Counter[] getBasicLittleHouseCounters(User user) {
        Counter[] counters = new Counter[4];

        counters[0] = new Counter("DaBeiZhou", Counter.Role.DABEI, 0, user);
        counters[1] = new Counter("XinJing", Counter.Role.BORUO, 0, user);
        counters[2] = new Counter("WangSheng", Counter.Role.WANGSHENG, 0, user);
        counters[3] = new Counter("QiFo", Counter.Role.QIFO, 0, user);

        return counters;
    }
}


