package org.example.gymnasticsscore.controller;

import org.example.gymnasticsscore.dto.MeetDTO;
import org.example.gymnasticsscore.model.Meet;
import org.example.gymnasticsscore.repository.MeetRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meets")
public class MeetController {

    private final MeetRepository meetRepository;

    public MeetController(MeetRepository meetRepository) {
        this.meetRepository = meetRepository;
    }

    @PostMapping
    public Meet createMeet(@RequestBody MeetDTO dto) {
        Meet meet = new Meet();
        meet.setName(dto.getName());
        meet.setDate(dto.getDate());
        return meetRepository.save(meet);
    }

    @GetMapping
    public List<Meet> getAllMeets() {
        return meetRepository.findAll();
    }
}