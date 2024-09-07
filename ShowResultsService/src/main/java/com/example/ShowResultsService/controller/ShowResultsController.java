package com.example.ShowResultsService.controller;

import com.example.ShowResultsService.entity.Result;
import com.example.ShowResultsService.service.AuthenticationServiceClient;
import com.example.ShowResultsService.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ShowResultsController {

    @Autowired
    private ResultsService resultsService;

    @Autowired
    private AuthenticationServiceClient authClient;

    @GetMapping("/show")
    public ModelAndView showResults(@RequestParam(required = false)  String username,
                              @RequestParam(required = false)  String password) {
        if (authClient.validateUser(username, password)) {
            ModelAndView modelAndView = new ModelAndView("showResults");
            List<Result> results = resultsService.getAllData();
            modelAndView.addObject("results", results);

            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("showResultsLogin");
            modelAndView.addObject("error", "Invalid credentials");
            return modelAndView;
        }
    }

}