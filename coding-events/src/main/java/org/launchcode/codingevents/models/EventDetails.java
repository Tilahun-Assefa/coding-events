package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity{

    @Size(max = 500, message = "Description too long!")
    private String description;

    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Location can not be blank!")
    private String location;

    @Positive(message = "Number of attendees must be one or more.")
    private int numberOfAttendee;

    @OneToOne(mappedBy = "eventDetails")
    @JoinColumn(name = "event_id")
    private Event event;

    public Event getEvent() {
        return event;
    }

    public EventDetails(){}

    public EventDetails(String description, String contactEmail, String location, int numberOfAttendee) {
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.numberOfAttendee = numberOfAttendee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfAttendee() {
        return numberOfAttendee;
    }

    public void setNumberOfAttendee(int numberOfAttendee) {
        this.numberOfAttendee = numberOfAttendee;
    }
}
