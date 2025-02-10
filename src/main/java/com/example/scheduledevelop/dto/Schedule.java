package com.example.scheduledevelop.dto;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "Longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule() {
    }

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }



}
