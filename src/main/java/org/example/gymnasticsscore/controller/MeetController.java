package org.example.gymnasticsscore.controller;

import jakarta.validation.Valid;
import org.example.gymnasticsscore.dto.MeetDTO;
import org.example.gymnasticsscore.model.Meet;
import org.example.gymnasticsscore.service.MeetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meets")
public class MeetController {

    private final MeetService meetService;

    public MeetController(MeetService meetService) {
        this.meetService = meetService;
    }

    @PostMapping
    public Meet createMeet(@Valid @RequestBody MeetDTO dto) {
        return meetService.createMeet(dto);
    }

    @GetMapping
    public List<Meet> getAllMeets() {
        return meetService.getAllMeets();
    }

    @GetMapping("/{id}")
    public Meet getMeetById(@PathVariable Long id) {
        return meetService.getMeetById(id);
    }

    @PutMapping("/{id}")
    public Meet updateMeet(
            @PathVariable Long id,
            @Valid @RequestBody MeetDTO dto) {

        return meetService.updateMeet(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteMeet(@PathVariable Long id) {
        meetService.deleteMeet(id);
    }
}