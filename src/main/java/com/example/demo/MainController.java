package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    CredentialRepository credentialRepository;
    @Autowired
    private UserdetailRepository userdetailRepository;

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

    public String username(@RequestParam("username") String username,
                           @RequestParam("firstname") String firstname,
                           @RequestParam("lastname") String lastname,
                           @RequestParam("email") String email,
                           @RequestParam("phone") String phone, HttpSession session){

        Userdetail userdetail=new Userdetail();
        userdetail.setUsername(username);
        userdetail.setFirstname(firstname);
        userdetail.setLastname((lastname));
        userdetail.setEmail(email);
        userdetail.setPhone(phone);
        return "dashboard" ;
    }




    @PostMapping("/login")
    public  String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session , Model model){
        Optional<Credential> matchCredential= credentialRepository.findById(username);
        if (matchCredential.isPresent()){
            if (matchCredential.get().getPassword().equals(password))
            {   session.setAttribute("username", username);
                Optional<Userdetail> userdetail= userdetailRepository.findById(username);
                if(userdetail.isPresent()){
                    model.addAttribute("userdetail",userdetail.get());
                }
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
