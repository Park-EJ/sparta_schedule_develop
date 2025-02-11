package com.example.scheduledevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "Longtext")
    private String contents;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    public Schedule() {
    }

    public Schedule(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

    public void updateById(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }
}
