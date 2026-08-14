package org.example.gymnasticsscore.controller;

import org.example.gymnasticsscore.dto.GymDTO;
import org.example.gymnasticsscore.model.Gym;
import org.example.gymnasticsscore.service.GymService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {

    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @PostMapping
    public Gym createGym(@Valid @RequestBody GymDTO dto) {
        return gymService.createGym(dto);
    }

    @GetMapping
    public List<Gym> getAllGyms() {
        return gymService.getAllGyms();
    }

    @GetMapping("/{id}")
    public Gym getGym(@PathVariable Long id) {
        return gymService.getGym(id);
    }

    @PutMapping("/{id}")
    public Gym updateGym(@PathVariable Long id, @Valid @RequestBody GymDTO dto) {
        return gymService.updateGym(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteGym(@PathVariable Long id) {
        gymService.deleteGym(id);
    }
}