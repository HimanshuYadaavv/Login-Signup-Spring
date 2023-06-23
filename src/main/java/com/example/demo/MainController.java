package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    CredentialRepository credentialRepository;

    @GetMapping("/Land")
    public String LandingPage(){
        return "LandingPage";
    }

    @PostMapping("/signup")
    public  String signup(@RequestParam("username") String username, @RequestParam("password") String password){

        Credential credential=new Credential();
        credential.setUsername(username);
        credential.setPassword(password);
        credentialRepository.save(credential);
        return "dashboard";
    }
    @PostMapping("/login")
    public  String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        Optional<Credential> matchCredential= credentialRepository.findById(username);
        if (matchCredential.isPresent()){
            if (matchCredential.get().getPassword().equals(password))
            {
                return "dashboard";
            }else
            {
                return "Landingpage";
            }

        }else {

            return "Landingpage";
        }



    }

}
