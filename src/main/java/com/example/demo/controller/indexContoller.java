package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexContoller {
    @GetMapping({"/","/index"})
    public String indexPage()
    {
        return "forward:/index.html";
    }
    @GetMapping("/add")
    public String addPage()
    {
        return "redirect:/add-employee.html";
    }
    @GetMapping("/update")
    public String updatePage()
    {
        return "redirect:/update-employee.html";
    }
    @GetMapping("/delete")
    public String deletePage()
    {
        return "redirect:/delete-employee.html";
    }
    @GetMapping("/view")
    public String viewPage()
    {
        return "redirect:/view-employee.html";
    }
}
