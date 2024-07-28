package com.fitsync.FitSync.service.impl;

import com.fitsync.FitSync.entities.Exercise;
import com.fitsync.FitSync.model.ExerciseTemplateRequest;
import com.fitsync.FitSync.model.ExerciseTemplateResponse;
import com.fitsync.FitSync.repositories.ExerciseTemplateRepo;
import com.fitsync.FitSync.service.ExerciseTemplateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;

@Log4j2
@Service
public class ExerciseTemplateImpl implements ExerciseTemplateService {

    @Autowired
    private ExerciseTemplateRepo exerciseTemplateRepo;

    @Override
    public String addExercise(ExerciseTemplateRequest exerciseTemplateRequest) {
        log.info("Adding the exercise...");
        Exercise exercise =
                Exercise.builder()
                        .exerciseName(exerciseTemplateRequest.getExerciseName())
                        .exerciseDesc(exerciseTemplateRequest.getExerciseDesc())
                        .exerciseType(exerciseTemplateRequest.getExerciseType())
                        .thumbnailUrl(exerciseTemplateRequest.getThumbnailUrl())
                        .primaryMuscleGroup(exerciseTemplateRequest.getPrimaryMuscleGroup())
                        .otherMuscles(exerciseTemplateRequest.getOtherMuscles())
                        .build();

        exerciseTemplateRepo.save(exercise);
        return exercise.getId();
    }

    @Override
    public ExerciseTemplateResponse getExerciseById(Long exerciseTemplateId) {
        log.info("Getting the Exercise for exerciseTemplateId: {}", exerciseTemplateId);
        Exercise exercise =
                exerciseTemplateRepo
                        .findById(exerciseTemplateId)
                        .orElseThrow(
                                () ->
                                        new RuntimeException("Exercise with id " + exerciseTemplateId + " not found"));

        ExerciseTemplateResponse exerciseTemplateResponse = new ExerciseTemplateResponse();
        copyProperties(exercise, exerciseTemplateResponse);
        return exerciseTemplateResponse;
    }

    @Override
    public List<ExerciseTemplateResponse> getAllExercises() {
        log.info("Getting all the exercises");
        List<ExerciseTemplateResponse> exerciseTemplateResponseList = new ArrayList<>();
        List<Exercise> allExerciseList = exerciseTemplateRepo.findAll();
        System.out.println(allExerciseList);
        for (Exercise entity : allExerciseList) {
            ExerciseTemplateResponse response = ExerciseTemplateResponse.builder()
                    .exerciseName(entity.getExerciseName())
                    .exerciseDesc(entity.getExerciseDesc())
                    .exerciseType(entity.getExerciseType())
                    .thumbnailUrl(entity.getThumbnailUrl())
                    .primaryMuscleGroup(entity.getPrimaryMuscleGroup())
                    .otherMuscles(entity.getOtherMuscles())
                    .build();
            exerciseTemplateResponseList.add(response);
        }


        return exerciseTemplateResponseList;
    }

    @Override
    public void removeExercise(Long exerciseTemplateId) {
        Exercise exercise =
                exerciseTemplateRepo
                        .findById(exerciseTemplateId)
                        .orElseThrow(
                                () ->
                                        new RuntimeException("Exercise with id " + exerciseTemplateId + " not found"));

        exerciseTemplateRepo.delete(exercise);
    }
}
