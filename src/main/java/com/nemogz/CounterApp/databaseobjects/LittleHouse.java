package com.nemogz.CounterApp.databaseobjects;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "LittleHouse")
public class LittleHouse {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    private String name;

    @Column (name = "littlehouse_count")
    private Integer LittleHouseCount;

    @Column (name = "lastChanged")
    private LocalDateTime lastChanged;

    @OneToOne
    @JoinColumn (name = "user")
    private User user;

    public LittleHouse(Long id, String name, Integer littleHouseCount, LocalDateTime lastChanged, User user) {
        this.id = id;
        this.name = name;
        LittleHouseCount = littleHouseCount;
        this.lastChanged = lastChanged;
        this.user = user;
    }

    public LittleHouse() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLittleHouseCount() {
        return LittleHouseCount;
    }

    public void setLittleHouseCount(Integer littleHouseCount) {
        LittleHouseCount = littleHouseCount;
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
