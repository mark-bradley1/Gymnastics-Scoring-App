package org.example.gymnasticsscore.controller;

import org.example.gymnasticsscore.dto.ScoresDTO;
import org.example.gymnasticsscore.model.Gymnast;
import org.example.gymnasticsscore.model.Meet;
import org.example.gymnasticsscore.model.Scores;
import org.example.gymnasticsscore.repository.GymnastRepository;
import org.example.gymnasticsscore.repository.MeetRepository;
import org.example.gymnasticsscore.repository.ScoresRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoresController {

    private final ScoresRepository scoresRepository;
    private final GymnastRepository gymnastRepository;
    private final MeetRepository meetRepository;

    public ScoresController(ScoresRepository scoresRepository,
                            GymnastRepository gymnastRepository,
                            MeetRepository meetRepository) {
        this.scoresRepository = scoresRepository;
        this.gymnastRepository = gymnastRepository;
        this.meetRepository = meetRepository;
    }

    @PostMapping
    public Scores createScore(@RequestBody ScoresDTO dto) {

        Gymnast gymnast = gymnastRepository.findById(dto.getGymnastId())
                .orElseThrow(() -> new RuntimeException("Gymnast not found"));

        Meet meet = meetRepository.findById(dto.getMeetId())
                .orElseThrow(() -> new RuntimeException("Meet not found"));

        Scores score = new Scores();
        score.setValue(dto.getValue());
        score.setEvent(dto.getEvent());
        score.setGymnast(gymnast);
        score.setMeet(meet);

        return scoresRepository.save(score);
    }

    @GetMapping
    public List<Scores> getAllScores() {
        return scoresRepository.findAll();
    }

    // 🔥 Key feature: scores by gym
    @GetMapping("/gym/{gymName}")
    public List<Scores> getScoresByGym(@PathVariable String gymName) {
        return scoresRepository.findByGymnast_Gym_Name(gymName);
    }
}