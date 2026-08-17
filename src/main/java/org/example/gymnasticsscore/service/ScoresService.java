package org.example.gymnasticsscore.service;

import org.example.gymnasticsscore.dto.ScoresDTO;
import org.example.gymnasticsscore.exception.DuplicateResourceException;
import org.example.gymnasticsscore.exception.ResourceNotFoundException;
import org.example.gymnasticsscore.model.Gymnast;
import org.example.gymnasticsscore.model.Meet;
import org.example.gymnasticsscore.model.Scores;
import org.example.gymnasticsscore.repository.GymnastRepository;
import org.example.gymnasticsscore.repository.MeetRepository;
import org.example.gymnasticsscore.repository.ScoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoresService {

    private final ScoresRepository scoresRepository;
    private final GymnastRepository gymnastRepository;
    private final MeetRepository meetRepository;

    public ScoresService(
            ScoresRepository scoresRepository,
            GymnastRepository gymnastRepository,
            MeetRepository meetRepository) {

        this.scoresRepository = scoresRepository;
        this.gymnastRepository = gymnastRepository;
        this.meetRepository = meetRepository;
    }

    public Scores createScore(ScoresDTO dto) {

        Gymnast gymnast = gymnastRepository.findById(dto.getGymnastId())
                .orElseThrow(() -> new ResourceNotFoundException("Gymnast not found"));

        Meet meet = meetRepository.findById(dto.getMeetId())
                .orElseThrow(() -> new ResourceNotFoundException("Meet not found"));

        if (scoresRepository.existsByGymnast_IdAndMeet_IdAndEvent(
                dto.getGymnastId(),
                dto.getMeetId(),
                dto.getEvent())) {

            throw new DuplicateResourceException(
                    "A score for this gymnast, meet, and event already exists"
            );
        }

        Scores score = new Scores();

        score.setValue(dto.getValue());
        score.setEvent(dto.getEvent());
        score.setGymnast(gymnast);
        score.setMeet(meet);

        return scoresRepository.save(score);
    }

    public Scores getScoreById(Long id) {
        return scoresRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));
    }

    public Scores updateScore(Long id, ScoresDTO dto) {

        Scores score = scoresRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found"));

        Gymnast gymnast = gymnastRepository.findById(dto.getGymnastId())
                .orElseThrow(() -> new ResourceNotFoundException("Gymnast not found"));

        Meet meet = meetRepository.findById(dto.getMeetId())
                .orElseThrow(() -> new ResourceNotFoundException("Meet not found"));

        boolean duplicateExists =
                scoresRepository.existsByGymnast_IdAndMeet_IdAndEvent(
                        dto.getGymnastId(),
                        dto.getMeetId(),
                        dto.getEvent()
                );

        if (duplicateExists && !isSameScore(score, dto)) {
            throw new DuplicateResourceException(
                    "A score for this gymnast, meet, and event already exists"
            );
        }

        score.setValue(dto.getValue());
        score.setEvent(dto.getEvent());
        score.setGymnast(gymnast);
        score.setMeet(meet);

        return scoresRepository.save(score);
    }

    private boolean isSameScore(Scores score, ScoresDTO dto) {
        return score.getGymnast().getId().equals(dto.getGymnastId())
                && score.getMeet().getId().equals(dto.getMeetId())
                && score.getEvent() == dto.getEvent();
    }

    public List<Scores> getAllScores() {
        return scoresRepository.findAll();
    }

    public List<Scores> getScoresByGym(String gymName) {
        return scoresRepository.findByGymnast_Gym_Name(gymName);
    }
}