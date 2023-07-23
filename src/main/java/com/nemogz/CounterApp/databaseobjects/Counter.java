package com.nemogz.CounterApp.databaseobjects;

import jakarta.persistence.*;

@Entity
@Table(name = "counters")
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String counterName;

    public enum Role {
        NONE, DABEI, BORUO, WANGSHENG, QIFO;
    }

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private Integer count;

    public Counter() {

    }

    public Counter(Long id, String counterName, Role role, Integer count) {
        this.id = id;
        this.counterName = counterName;
        this.role = role;
        this.count = count;
    }
}
