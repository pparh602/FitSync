package com.fitsync.FitSync.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rep {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Integer repNumber;
    private Double weight;
    private Boolean successful;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private Set set;
}
