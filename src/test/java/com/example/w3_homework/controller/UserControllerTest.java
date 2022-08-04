package com.example.w3_homework.controller;

import com.example.w3_homework.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

//    @Test
//    void gotoSignUp() {
//    }

    @Test
    void signUp() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setPassword("test");
        userDto.setUsername("test");
        String content = objectMapper.writeValueAsString(userDto);
        mockMvc.perform(post("/user/signup")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

//    @Test
//    void gotoSignIn() {
//    }
//
//    @Test
//    void signIn() {
//    }
//
//    @Test
//    void signOut() {
//    }
//
//    @Test
//    void gotoPasswordUpdate() {
//    }
//
//    @Test
//    void updatePassword() {
//    }
}