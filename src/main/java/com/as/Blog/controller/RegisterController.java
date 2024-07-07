package com.as.Blog.controller;


import com.as.Blog.model.Account;
import com.as.Blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequiredArgsConstructor
public class RegisterController {

    @Autowired
    AccountService accountService;



    @PostMapping("/register")
    public String registerSave(@RequestBody Account account) {
        accountService.save(account);
        return "redirect:/";
    }


    @GetMapping("/register")
    public String getregister() {
        return "register";
    }


}
