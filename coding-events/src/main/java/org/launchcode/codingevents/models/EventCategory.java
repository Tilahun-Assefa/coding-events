package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory extends AbstractEntity {

    @Size(min=3, message = "Names must be at least 3 characters long")
    private String name;

    @OneToMany(mappedBy = "eventCategory")
    private final List<Event> events = new ArrayList<>();

    public EventCategory(){}

    public EventCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }
}
