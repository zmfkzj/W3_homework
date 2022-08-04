package com.example.w3_homework.service;

import com.example.w3_homework.dto.PassDto;
import com.example.w3_homework.dto.UserDto;
import com.example.w3_homework.model.User;
import com.example.w3_homework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDto userDto){
        String username = userDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()){
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }

        String password = passwordEncoder.encode(userDto.getPassword());
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        userRepository.save(user);
    }

    public void passwordUpdate(PassDto passDto, Long userId){
        Optional<User> found = userRepository.findById(userId);
        if (found.isEmpty()){
            throw  new IllegalArgumentException("사용자 ID가 존재하지 않습니다.");
        }
        found.orElseThrow().update(passDto);
    }

}
