package com.nemogz.CounterApp.databaseobjects;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "count")
    private String count;

    @Column (name = "last_changed")
    private LocalDateTime lastChanged;

    @OneToOne
    @JoinColumn (name = "user")
    private User user;

    public Homework(Long id, String name, String count, LocalDateTime lastChanged, User user) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.lastChanged = lastChanged;
        this.user = user;
    }

    public Homework() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public LocalDateTime getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(LocalDateTime lastChanged) {
        this.lastChanged = lastChanged;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
