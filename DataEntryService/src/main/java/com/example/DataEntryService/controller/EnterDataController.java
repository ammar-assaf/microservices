package com.example.DataEntryService.controller;

import com.example.DataEntryService.entity.Data;
import com.example.DataEntryService.service.AuthenticationServiceClient;
import com.example.DataEntryService.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/data")
public class EnterDataController {

    @Autowired
    private DataService dataService;

    @Autowired
    private AuthenticationServiceClient authClient;

    @GetMapping("/enter")
    public String enterData(Model model) {
        model.addAttribute("dataEntry", new Data());
        return "enterData";
    }

    @PostMapping("/enter")
    public String submitData(@ModelAttribute Data data,
                             @RequestParam String username,
                             @RequestParam String password,
                             Model model) {
        if (authClient.validateUser(username, password)) {
            dataService.saveData(data);
            return "redirect:/data/enter";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "enterData";
        }
    }
}