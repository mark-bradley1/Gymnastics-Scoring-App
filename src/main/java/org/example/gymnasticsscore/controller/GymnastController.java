package org.example.gymnasticsscore.controller;

import org.example.gymnasticsscore.model.Gymnast;
import org.example.gymnasticsscore.repository.GymnastRepository;
import org.example.gymnasticsscore.dto.GymnastDTO;
import org.example.gymnasticsscore.model.Gym;
import org.example.gymnasticsscore.repository.GymRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gymnasts")
public class GymnastController {

    private final GymnastRepository gymnastRepository;
    private final GymRepository gymRepository;

    public GymnastController(GymnastRepository gymnastRepository, GymRepository gymRepository) {
        this.gymnastRepository = gymnastRepository;
        this.gymRepository = gymRepository;
    }

    @PostMapping
    public Gymnast createGymnast(@RequestBody GymnastDTO dto) {
        Gym gym = gymRepository.findById(dto.getGymId())
                .orElseThrow(() -> new RuntimeException("Gym not found"));

        Gymnast gymnast = new Gymnast();
        gymnast.setName(dto.getName());
        gymnast.setAge(dto.getAge());
        gymnast.setLevel(dto.getLevel());
        gymnast.setGender(dto.getGender());
        gymnast.setGym(gym);

        return gymnastRepository.save(gymnast);
    }

    @GetMapping
    public List<Gymnast> getAllGymnasts() {
        return gymnastRepository.findAll();
    }
}
