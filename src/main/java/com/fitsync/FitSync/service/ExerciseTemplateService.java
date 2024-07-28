package com.fitsync.FitSync.service;


import com.fitsync.FitSync.model.ExerciseTemplateRequest;
import com.fitsync.FitSync.model.ExerciseTemplateResponse;

import java.util.List;

public interface ExerciseTemplateService {

    String addExercise(ExerciseTemplateRequest exerciseTemplateRequest0);

    ExerciseTemplateResponse getExerciseById(Long exerciseTemplateId);

    List<ExerciseTemplateResponse> getAllExercises();

    void removeExercise(Long exerciseTemplateId);

}
