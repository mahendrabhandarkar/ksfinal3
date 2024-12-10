package com.ks.ksfinal3.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/index")
    public String landingPage(Model model, HttpServletResponse response) {
        //model.addAttribute("model", new )
        logger.info("I am here");
        String username = new String("""
                Welcome to My JTE Application,
                This is the main content.""");

        // Add the content object to the model
        model.addAttribute("username", username);

        return "pages/home";
    }
}
