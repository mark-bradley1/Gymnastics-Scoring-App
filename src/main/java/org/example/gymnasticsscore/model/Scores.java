package org.example.gymnasticsscore.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "scores")
public class Scores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "gymnast_id", nullable = false)
    private Gymnast gymnast;

    @ManyToOne
    @JoinColumn(name = "meet_id", nullable = false)
    private Meet meet;

    public Scores() {}

    public Scores(double value, Event event, Gymnast gymnast, Meet meet) {
        this.value = value;
        this.event = event;
        this.gymnast = gymnast;
        this.meet = meet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Gymnast getGymnast() {
        return gymnast;
    }

    public void setGymnast(Gymnast gymnast) {
        this.gymnast = gymnast;
    }

    public Meet getMeet() {
        return meet;
    }

    public void setMeet(Meet meet) {
        this.meet = meet;
    }
}
