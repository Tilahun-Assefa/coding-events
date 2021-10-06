package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
   private static List<String> events = new ArrayList<>();

    //respond for localhost:8080/events
    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", events);
        return "events/index";
    }

    //lives at localhost:8080/events/create
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    //lives at localhost:8080/events/create but for post
    @PostMapping("create")
    public String processCreateEventForm(@RequestParam String eventName){
        events.add(eventName);
        return "redirect:";
    }
}
