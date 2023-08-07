package com.nemogz.CounterApp.databaseobjects;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "user_name", nullable = false ,unique = true)
    private String userName;

    @Column (name = "password", nullable = false)
    private String password;

    @Column (name = "salt", nullable = false)
    private String salt;

    @Column (name = "date_created")
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "user")
    private List<Counter> counters;
    @OneToOne (mappedBy = "user")
    private LittleHouse littleHouse;

    @OneToOne (mappedBy = "user")
    private Homework homework;

    public LittleHouse getLittleHouse() {
        return littleHouse;
    }

    public void setLittleHouse(LittleHouse littleHouse) {
        this.littleHouse = littleHouse;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<Counter> getCounters() {
        return counters;
    }

    public void setCounters(List<Counter> counters) {
        this.counters = counters;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    public User(Long id, String userName, String password, String salt, LocalDateTime dateCreated) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.dateCreated = dateCreated;
    }
}
