package org.example.gymnasticsscore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "gym")
    @JsonIgnore
    private List<Gymnast> gymnasts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gymnast> getGymnasts() {
        return gymnasts;
    }

    public void setGymnasts(List<Gymnast> gymnasts) {
        this.gymnasts = gymnasts;
    }
}
