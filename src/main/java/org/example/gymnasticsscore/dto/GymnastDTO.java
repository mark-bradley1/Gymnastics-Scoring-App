package org.example.gymnasticsscore.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GymnastDTO {

    @NotBlank(message = "Gymnast name is required")
    private String name;

    @Min(value = 1, message = "Age must be at least 1")
    @Max(value = 100, message = "Age must be 100 or less")
    private int age;

    @NotBlank(message = "Level is required")
    private String level;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Gym ID is required")
    private Long gymId;

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }
}