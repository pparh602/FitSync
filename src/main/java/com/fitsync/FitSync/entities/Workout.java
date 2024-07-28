package com.fitsync.FitSync.entities;

import com.google.type.DateTime;
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
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String name;
    private String description;
    private Date date;
    private DateTime startTime;
    private DateTime endTime;
    private int nthWorkout;

    @OneToMany(mappedBy = "workout")
    private List<Set> sets;

}

