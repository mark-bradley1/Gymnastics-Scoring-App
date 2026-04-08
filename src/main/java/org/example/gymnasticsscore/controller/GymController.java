package org.example.gymnasticsscore.controller;

import org.example.gymnasticsscore.repository.GymRepository;
import org.example.gymnasticsscore.dto.GymDTO;
import org.example.gymnasticsscore.model.Gym;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {

    private final GymRepository gymRepository;

    public GymController(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    @PostMapping
    public Gym createGym(@RequestBody GymDTO dto) {
        Gym gym = new Gym();
        gym.setName(dto.getName());
        return gymRepository.save(gym);
    }

    @GetMapping
    public List<Gym> getAllGyms() {
        return gymRepository.findAll();
    }
}