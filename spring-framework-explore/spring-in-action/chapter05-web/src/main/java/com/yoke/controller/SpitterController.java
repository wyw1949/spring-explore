package com.yoke.controller;

import com.yoke.model.Spitter;
import com.yoke.repository.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping({"/spitter"})
public class SpitterController {

    @Autowired
    private SpitterRepository spitterRepository;


    @GetMapping("/register")
    public String showRegisterForm(){
        return "registerForm";
    }

    @PostMapping("/register")
    public String processRegistration(
            @Validated({Spitter.SaveSpitter.class}) Spitter spitter,
            Errors error){
        if (error.hasErrors()){
            return "registerForm";
        }
        spitter.setRegisterTime(new Date());
        spitterRepository.save(spitter);

        return "redirect:/spitter/" + spitter.getUsername();
    }

    @GetMapping("/{username}")
    public String showSpitterProfile(@PathVariable("username") String username, Model model){
        Spitter spitter = spitterRepository.findSpitterByUsername(username);
        model.addAttribute("spitter", spitter);
        return "profile";
    }


    public void setSpitterRepository(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }
}
