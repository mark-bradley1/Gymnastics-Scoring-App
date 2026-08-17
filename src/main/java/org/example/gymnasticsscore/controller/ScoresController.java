package org.example.gymnasticsscore.controller;

import org.example.gymnasticsscore.dto.ScoresDTO;
import org.example.gymnasticsscore.model.Scores;
import org.example.gymnasticsscore.service.ScoresService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoresController {

    private final ScoresService scoresService;

    public ScoresController(ScoresService scoresService) {
        this.scoresService = scoresService;
    }

    @PostMapping
    public Scores createScore(@RequestBody ScoresDTO dto) {
        return scoresService.createScore(dto);
    }

    @GetMapping
    public List<Scores> getAllScores() {
        return scoresService.getAllScores();
    }

    @GetMapping("/gym/{gymName}")
    public List<Scores> getScoresByGym(@PathVariable String gymName) {
        return scoresService.getScoresByGym(gymName);
    }

    @GetMapping("/{id}")
    public Scores getScoreById(@PathVariable Long id) {
        return scoresService.getScoreById(id);
    }

    @PutMapping("/{id}")
    public Scores updateScore(
            @PathVariable Long id,
            @RequestBody ScoresDTO dto) {

        return scoresService.updateScore(id, dto);
    }
}