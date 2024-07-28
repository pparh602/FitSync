package com.fitsync.FitSync.repositories;

import com.fitsync.FitSync.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseTemplateRepo extends JpaRepository<Exercise, Long> {

}
