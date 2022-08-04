package com.example.w3_homework.controller;

import com.example.w3_homework.dto.PassDto;
import com.example.w3_homework.dto.SignInDto;
import com.example.w3_homework.dto.UserDto;
import com.example.w3_homework.security.UserDetailsImpl;
import com.example.w3_homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String gotoSignUp(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody UserDto userDto){
        userService.registerUser(userDto);
        return "redirect:/user/signin";
    }

    @GetMapping("/signin")
    public String gotoSignIn(){
        return "signin";
    }

    @PostMapping("/signin")
    public void signIn(@RequestBody SignInDto signInDto){
    }

    @GetMapping("/signout")
    public void signOut(){
        return ;
    }

    @GetMapping("/password")
    public String gotoPasswordUpdate(){
        return "아직 페이지가 없어요...ㅠㅠㅠㅠㅠ";
    }

    @PostMapping("/password")
    public String updatePassword(@RequestBody PassDto passDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long userId = userDetails.getUser().getId();
        userService.passwordUpdate(passDto, userId);
        return "redirect:/user/signin";
    }

}
