package com.fitsync.FitSync.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseTemplateRequest {
    private String exerciseName;
    private String exerciseDesc;
    private String exerciseType;
    private String equipmentCategory;
    private String thumbnailUrl;
    private String primaryMuscleGroup;
    private List<String> otherMuscles;
}
