package org.example.gymnasticsscore.service;

import org.example.gymnasticsscore.dto.MeetDTO;
import org.example.gymnasticsscore.exception.ResourceNotFoundException;
import org.example.gymnasticsscore.model.Meet;
import org.example.gymnasticsscore.repository.MeetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetService {

    private final MeetRepository meetRepository;

    public MeetService(MeetRepository meetRepository) {
        this.meetRepository = meetRepository;
    }

    public Meet createMeet(MeetDTO dto) {
        Meet meet = new Meet();

        meet.setName(dto.getName());
        meet.setDate(dto.getDate());

        return meetRepository.save(meet);
    }

    public List<Meet> getAllMeets() {
        return meetRepository.findAll();
    }

    public Meet getMeetById(Long id) {
        return meetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meet not found"));
    }

    public Meet updateMeet(Long id, MeetDTO dto) {

        Meet meet = meetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meet not found"));

        meet.setName(dto.getName());
        meet.setDate(dto.getDate());

        return meetRepository.save(meet);
    }

    public void deleteMeet(Long id) {

        Meet meet = meetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Meet not found"));

        meetRepository.delete(meet);
    }
}