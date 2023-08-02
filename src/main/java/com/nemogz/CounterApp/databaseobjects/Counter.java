package com.nemogz.CounterApp.databaseobjects;

import jakarta.persistence.*;

@Entity
@Table(name = "counters")
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String counterName;

    public enum Role {
        NONE, DABEI, BORUO, WANGSHENG, QIFO;
    }

    @Column (name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column (name = "count")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

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

    public Counter() {

    }

    public Counter(String counterName, Role role, Integer count) {
        this.counterName = counterName;
        this.role = role;
        this.count = count;
    }

    public Counter(String counterName, Role role, Integer count, User user) {
        this.counterName = counterName;
        this.role = role;
        this.count = count;
        this.user = user;
    }
}
