package com.nc.college.bazaar.controller;

import com.nc.college.bazaar.model.UserModel;
import com.nc.college.bazaar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/college-bazaar")
public class HomeController {
    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String getAll(){
        return "Wellcome to college Bazaar";
    }

    @PostMapping
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel userModel)
    {
        return new ResponseEntity(userService.createUser(userModel), HttpStatus.CREATED);
    }
    @GetMapping
    public  UserModel getUser(@RequestBody UserModel userModel)
    {
        return  userService.getUser(userModel);
    }
}
