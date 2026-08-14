package org.example.gymnasticsscore.dto;

import jakarta.validation.constraints.NotBlank;

public class GymDTO {

    @NotBlank(message = "Gym name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
