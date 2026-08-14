package org.example.gymnasticsscore.repository;

import org.example.gymnasticsscore.model.Event;
import org.example.gymnasticsscore.model.Scores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoresRepository extends JpaRepository<Scores, Long> {
    List<Scores> findByGymnast_Gym_Name(String gymName);

    boolean existsByGymnast_IdAndMeet_IdAndEvent(
            Long gymnastId,
            Long meetId,
            Event event
    );

}