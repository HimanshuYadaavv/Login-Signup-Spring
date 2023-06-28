package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/0.1")
public class MainRestController {

@Autowired
UsertypelinkRepository usertypelinkRepository;

@GetMapping("/getusertypes")
public List<Usertypelink> getUserType(@RequestParam("username") String username){

    return usertypelinkRepository.findbyUsername(username);
    }






}
