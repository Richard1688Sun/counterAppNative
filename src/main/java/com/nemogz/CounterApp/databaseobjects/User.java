package com.nemogz.CounterApp.databaseobjects;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String salt;

    @Column
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "id")
    private List<Counter> counters;

    public User() {
    }

    public User(Long id, String userName, String password, String salt, LocalDateTime dateCreated, List<Counter> counters) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.dateCreated = dateCreated;
        this.counters = counters;
    }
}
