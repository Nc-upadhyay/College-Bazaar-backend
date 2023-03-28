package com.nc.college.bazaar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("college/bazaar")
public class HomeController {
    @RequestMapping
    public String getAll(){
        return "Wellcome to college Bazaar";
    }
}
