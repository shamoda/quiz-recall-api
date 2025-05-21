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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(unique=true)
    private String mobileNo;
    private int fee;
    private boolean isActive; // active/inactive
    private int studentRank;
    @ManyToOne
    @JoinColumn(name = "referred_by")
    private User referredBy;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp()
    private LocalDateTime lastUpdated;
}
