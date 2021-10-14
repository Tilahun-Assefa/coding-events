package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    //respond for localhost:8080/events
    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    //lives at localhost:8080/events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    //lives at localhost:8080/events/create but for post
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Event");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditEventForm(Model model, @PathVariable int eventId) {
        Event eventToEdit = EventData.getById(eventId);
        String title = "Edit Event " + eventToEdit.getName() + " (id= " + eventToEdit.getId() + ")";
        model.addAttribute("title", title);
        model.addAttribute("event", eventToEdit);
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditEventForm(int eventId, String name, String description) {
        Event editEvent = EventData.getById(eventId);
        editEvent.setName(name);
        editEvent.setDescription(description);
        return "redirect:";
    }
}
