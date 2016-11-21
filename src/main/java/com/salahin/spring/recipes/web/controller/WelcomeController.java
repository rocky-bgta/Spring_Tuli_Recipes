package com.salahin.spring.recipes.web.controller;

import com.salahin.spring.recipes.service.recipeinterface.HomeMadeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class  WelcomeController {

    @Autowired
    private HomeMadeServiceInterface homeMadeServiceInterface;

    @RequestMapping(value = {"/tulirecipes"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        Date today = new Date();
        model.addAttribute("WelcomeMessage", homeMadeServiceInterface.welcomeMessage);
        model.addAttribute("today", today);
        return "welcome";
    }


    /*@RequestMapping(value = "/index.html")
    public class LoginController{

    }*/

   /* @RequestMapping(value = {"/start","/"}, method = RequestMethod.GET)
    public String showHomePage() {
        return "/static/index.html";
    }*/

}
