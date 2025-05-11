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
public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String medium;
    private String type; // past paper/model paper
    @ManyToOne
    @JoinColumn(name = "exam")
    private Exam exam; // OL/AL/Scholarship
    private String subject;
    private int year;
    private String status; // draft/published/unpublished
    private int duration;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp()
    private LocalDateTime lastUpdated;

}
