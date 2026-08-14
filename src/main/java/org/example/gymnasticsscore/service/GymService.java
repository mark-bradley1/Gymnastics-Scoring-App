package org.example.gymnasticsscore.service;

import org.example.gymnasticsscore.dto.GymDTO;
import org.example.gymnasticsscore.exception.DuplicateResourceException;
import org.example.gymnasticsscore.exception.ResourceNotFoundException;
import org.example.gymnasticsscore.model.Gym;
import org.example.gymnasticsscore.repository.GymRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {

    private final GymRepository gymRepository;

    public GymService(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }

    public Gym createGym(GymDTO dto) {

        if (gymRepository.existsByName(dto.getName())) {
            throw new DuplicateResourceException(
                    "A gym with that name already exists"
            );
        }
        Gym gym = new Gym();
        gym.setName(dto.getName());

        return gymRepository.save(gym);
    }

    public List<Gym> getAllGyms() {
        return gymRepository.findAll();
    }

    public Gym getGym(Long id) {
        return gymRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gym not found"));
    }

    public Gym updateGym(Long id, GymDTO dto) {
        Gym gym = gymRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gym not found"));

        if (gymRepository.existsByNameAndIdNot(dto.getName(), id)) {
            throw new DuplicateResourceException(
                    "A gym with that name already exists"
            );
        }

        gym.setName(dto.getName());

        return gymRepository.save(gym);
    }

    public void deleteGym(Long id) {
        Gym gym = gymRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gym not found"));

        gymRepository.delete(gym);
    }
}