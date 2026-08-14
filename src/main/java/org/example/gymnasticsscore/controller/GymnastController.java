package org.example.gymnasticsscore.controller;

import org.example.gymnasticsscore.model.Gymnast;
import org.example.gymnasticsscore.dto.GymnastDTO;
import org.example.gymnasticsscore.service.GymnastService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gymnasts")
public class GymnastController {

    private final GymnastService gymnastService;

    public GymnastController(GymnastService gymnastService) {
        this.gymnastService = gymnastService;
    }

    @PostMapping
    public Gymnast createGymnast(@RequestBody GymnastDTO dto) {
        return gymnastService.createGymnast(dto);
    }

    @GetMapping
    public List<Gymnast> getAllGymnasts() {
        return gymnastService.getAllGymnasts();
    }

    @GetMapping("/{id}")
    public Gymnast getGymnast(@PathVariable Long id) {
        return gymnastService.getGymnast(id);
    }

    @PutMapping("/{id}")
    public Gymnast updateGymnast(
            @PathVariable Long id,
            @RequestBody GymnastDTO dto) {
        return gymnastService.updateGymnast(id, dto);
    }
}