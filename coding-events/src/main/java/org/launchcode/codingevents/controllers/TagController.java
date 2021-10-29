package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.TagRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("tags")
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    //respond for localhost:8080/tags
    @GetMapping
    public String displayAllTags(Model model){
        model.addAttribute("title", "All Tags");
        model.addAttribute("tags", tagRepository.findAll());
        return "tags/index";
    }

    //lives at localhost:8080/tags/create
    @GetMapping("create")
    public String renderCreateTagsForm(Model model){
        model.addAttribute("title", "Create Tag");
        model.addAttribute(new Tag());
        return "tags/create";
    }

    //lives at localhost:8080/tags/create but for post
    @PostMapping("create")
    public String processCreateTagForm(@ModelAttribute @Valid Tag newTag, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("title", "Create Tag");
            return "tags/create";
        }
        tagRepository.save(newTag);
        return "redirect:";
    }
}