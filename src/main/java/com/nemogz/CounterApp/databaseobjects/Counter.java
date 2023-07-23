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

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public Role getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Counter() {

    }

    public Counter(Long id, String counterName, Role role, Integer count) {
        this.id = id;
        this.counterName = counterName;
        this.role = role;
        this.count = count;
    }
}
