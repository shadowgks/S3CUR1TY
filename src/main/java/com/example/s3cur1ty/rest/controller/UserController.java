package com.example.s3cur1ty.rest.controller;

import com.example.s3cur1ty.config.JwtService;
import com.example.s3cur1ty.dto.req.LoginDTO;
import com.example.s3cur1ty.dto.req.RegisterReqDTO;
import com.example.s3cur1ty.dto.res.UserResDTO;
import com.example.s3cur1ty.mapper.UserMapper;
import com.example.s3cur1ty.model.entites.AppUser;
import com.example.s3cur1ty.service.UserService;
import com.example.s3cur1ty.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;
//    @GetMapping
//    public ResponseEntity<List<AppUser>> findAllUser(){
//        List<AppUser> userList = userService.();
//        return ResponseEntity.ok(userList);
//    }
//    @GetMapping("/{username}")
//    public ResponseEntity<AppUser> findUserByUsername(@Valid @PathVariable("username") String username){
//        AppUser user = userService.findByUsernameUser(username);
//        return ResponseEntity.ok(user);
//    }
    @PostMapping("/register")
    public ResponseEntity<UserResDTO> register(@Valid @RequestBody RegisterReqDTO registerReqDTO){
        Response<UserResDTO> response = new Response();
        AppUser user = userService.register(UserMapper.toEntity(registerReqDTO));
        //generate new Token
        String jwtToken = jwtService.generateToken(user);
        return new ResponseEntity<>(UserMapper.toDto(user, jwtToken), HttpStatus.CREATED);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<UserResDTO> authenticate(@Valid @RequestBody LoginDTO authenticateReqDto){
        Response<UserResDTO> response = new Response();
        AppUser user = userService.authenticate(UserMapper.toEntity(authenticateReqDto));
        //generate new Token
        String jwtToken = jwtService.generateToken(user);
        return new ResponseEntity<>(UserMapper.toDto(user, jwtToken), HttpStatus.OK);
    }
}
