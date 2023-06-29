package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/0.1")
@CrossOrigin
public class MainRestController {



@Autowired
UsertypelinkRepository usertypelinkRepository;
    @Autowired
    private UserdetailRepository userdetailRepository;


    @GetMapping("/newuserdetail")
    public Userdetail getDummyUser(){
    Userdetail userdetail=new Userdetail();
    userdetail.setUsername("username");
    userdetail.setFirstname("firstname");
    userdetail.setLastname("lastname");
    userdetail.setEmail("email");
    userdetail.setPhone("phone");
    return userdetail;
}

@GetMapping("/getusertypes")
public List<Usertypelink> getUserType(@RequestParam("username") String username){

    return usertypelinkRepository.findbyUsername(username);
    }






}
