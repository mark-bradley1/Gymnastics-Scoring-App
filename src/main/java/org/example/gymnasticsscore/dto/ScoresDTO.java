package org.example.gymnasticsscore.dto;

import org.example.gymnasticsscore.model.Event;

public class ScoresDTO {
    private double value;
    private Event event;
    private Long gymnastId;
    private Long meetId;

    // getters & setters

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

    public Long getGymnastId() {
        return gymnastId;
    }

    public void setGymnastId(Long gymnastId) {
        this.gymnastId = gymnastId;
    }

    public Long getMeetId() {
        return meetId;
    }

    public void setMeetId(Long meetId) {
        this.meetId = meetId;
    }
}
