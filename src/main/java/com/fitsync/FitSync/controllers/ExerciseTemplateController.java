package com.fitsync.FitSync.controllers;

import com.fitsync.FitSync.model.ExerciseTemplateRequest;
import com.fitsync.FitSync.model.ExerciseTemplateResponse;
import com.fitsync.FitSync.service.ExerciseTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exercise")
@CrossOrigin("*")
public class ExerciseTemplateController {

  @Autowired private ExerciseTemplateService exerciseTemplateService;

  @GetMapping("/")
  public ResponseEntity<List<ExerciseTemplateResponse>> getAllExercises() {
    return new ResponseEntity<>(exerciseTemplateService.getAllExercises(), HttpStatus.OK);
  }

  @GetMapping("/{exerciseTemplateId}")
  public ResponseEntity<ExerciseTemplateResponse> getExerciseTemplateById(
      @PathVariable Long exerciseTemplateId) {
    ExerciseTemplateResponse exerciseTemplateResponse =
        exerciseTemplateService.getExerciseById(exerciseTemplateId);
    return new ResponseEntity<>(exerciseTemplateResponse, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<String> addExerciseTemplate(
      @RequestBody ExerciseTemplateRequest exerciseTemplateRequest) {
    String exerciseId = exerciseTemplateService.addExercise(exerciseTemplateRequest);
    return new ResponseEntity<>(exerciseId, HttpStatus.OK);
  }
}
