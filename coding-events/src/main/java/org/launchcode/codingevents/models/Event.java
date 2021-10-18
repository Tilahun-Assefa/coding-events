package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextId=1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotBlank(message = "Location can not be blank!")
    private String location;

    @AssertTrue(message = "Attendee must register for the event")
    private boolean registered;

    @Positive(message = "Number of attendees must be one or more.")
    private int numberOfAttendee;

    @Past(message = "Registration date must be now or past")
    private LocalDateTime registrationDate;

    public Event(){
        this.id=nextId;
        nextId++;
        registrationDate= LocalDateTime.now();
    }
    public Event(String name, String description, String contactEmail, String location, boolean registered ) {
        this();
        this.name = name;
        this.description= description;
        this.contactEmail= contactEmail;
        this.location= location;
        this.registered= registered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public int getNumberOfAttendee() {
        return numberOfAttendee;
    }

    public void setNumberOfAttendee(int numberOfAttendee) {
        this.numberOfAttendee = numberOfAttendee;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }


    public boolean isRegistered() {
        return registered;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
