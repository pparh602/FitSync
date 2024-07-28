package com.fitsync.FitSync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer rep;
    private Double weight;
    private Boolean isWarmup;
    private Boolean isDropSet;
    private Boolean isFailureSet;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @OneToMany(mappedBy = "set")
    private List<Rep> reps;
}
