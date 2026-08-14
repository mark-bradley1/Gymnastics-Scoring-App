package org.example.gymnasticsscore.service;

import org.example.gymnasticsscore.dto.GymnastDTO;
import org.example.gymnasticsscore.exception.ResourceNotFoundException;
import org.example.gymnasticsscore.model.Gym;
import org.example.gymnasticsscore.model.Gymnast;
import org.example.gymnasticsscore.repository.GymRepository;
import org.example.gymnasticsscore.repository.GymnastRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymnastService {

    private final GymnastRepository gymnastRepository;
    private final GymRepository gymRepository;

    public GymnastService(GymnastRepository gymnastRepository,
                          GymRepository gymRepository) {
        this.gymnastRepository = gymnastRepository;
        this.gymRepository = gymRepository;
    }

    public Gymnast createGymnast(GymnastDTO dto) {

        Gym gym = gymRepository.findById(dto.getGymId())
                .orElseThrow(() -> new ResourceNotFoundException("Gym not found"));

        Gymnast gymnast = new Gymnast();

        gymnast.setName(dto.getName());
        gymnast.setAge(dto.getAge());
        gymnast.setLevel(dto.getLevel());
        gymnast.setGender(dto.getGender());
        gymnast.setGym(gym);

        return gymnastRepository.save(gymnast);
    }

    public List<Gymnast> getAllGymnasts() {
        return gymnastRepository.findAll();
    }

    public Gymnast getGymnast(Long id) {
        return gymnastRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gymnast not found"));
    }

    public Gymnast updateGymnast(Long id, GymnastDTO dto) {

        Gymnast gymnast = gymnastRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gymnast not found"));

        Gym gym = gymRepository.findById(dto.getGymId())
                .orElseThrow(() -> new ResourceNotFoundException("Gym not found"));

        gymnast.setName(dto.getName());
        gymnast.setAge(dto.getAge());
        gymnast.setLevel(dto.getLevel());
        gymnast.setGender(dto.getGender());
        gymnast.setGym(gym);

        return gymnastRepository.save(gymnast);
    }
}