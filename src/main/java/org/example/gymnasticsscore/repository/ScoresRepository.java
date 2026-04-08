package org.example.gymnasticsscore.repository;

import org.example.gymnasticsscore.model.Scores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoresRepository extends JpaRepository<Scores, Long> {
    List<Scores> findByGymnast_Gym_Name(String gymName);

}