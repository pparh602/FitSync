package com.fitsync.FitSync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String exerciseName;
    private String exerciseDesc;
    private String exerciseType;
    private String equipmentCategory;
    private String thumbnailUrl;
    private String primaryMuscleGroup;
    private List<String> otherMuscles;

    @OneToMany(mappedBy = "exercise")
    private Set<Note> notes;

}