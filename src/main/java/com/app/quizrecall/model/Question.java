package com.app.quizrecall.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int number;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private String type; // essay/single answer/multiple answer
    private String category; // sections of syllabus
    @ManyToOne
    @JoinColumn(name = "paper")
    private Paper paper;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp()
    private LocalDateTime lastUpdated;
}
