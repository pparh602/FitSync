package com.fitsync.FitSync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String password;
    private String email;
    private Date dateJoined;

    @OneToMany(mappedBy = "user")
    private List<Routine> routines;

    @OneToMany(mappedBy = "user")
    private List<Workout> workouts;
}
