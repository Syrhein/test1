package com.smhrd.src.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/grants")
    public String grantsPage() {
        return "grants";
    }
    
    @GetMapping("/grants/detail/{seq}")
    public String grantDetailPage(@PathVariable String seq, Model model) {
        model.addAttribute("seq", seq);
        return "grant-detail";
    }
    
    
}
