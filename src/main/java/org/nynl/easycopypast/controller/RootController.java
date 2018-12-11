package org.nynl.easycopypast.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

public class RootController {

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "index";
    }
}
