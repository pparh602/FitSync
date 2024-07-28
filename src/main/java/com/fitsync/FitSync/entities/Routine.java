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
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String usrId;
    private String routineName;
    private String description;
    private List<Exercise> exercises;
}
