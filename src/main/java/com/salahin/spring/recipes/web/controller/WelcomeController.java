package com.salahin.spring.recipes.web.controller;

import com.salahin.spring.recipes.service.recipeinterface.HomeMadeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping(value = {"/welcome", "/"}, method = RequestMethod.GET)
public class WelcomeController {

    HomeMadeServiceInterface homeMadeServiceInterface;

    @Autowired
    public WelcomeController(HomeMadeServiceInterface homeMadeServiceInterface){
        this.homeMadeServiceInterface = homeMadeServiceInterface;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String welcome(Model model) {
        Date today = new Date();
        model.addAttribute("WelcomeMessage", homeMadeServiceInterface.welcomeMessage);
        model.addAttribute("today", today);
        return "welcome";
    }

}
