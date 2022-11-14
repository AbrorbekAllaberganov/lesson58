package com.example.lesson58.controller;

import com.example.lesson58.entity.User;
import com.example.lesson58.model.Result;
import com.example.lesson58.payload.LoginPayload;
import com.example.lesson58.repository.UserRepository;
import com.example.lesson58.security.JwtTokenProvider;
import com.example.lesson58.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RoleServiceImpl roleService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> getLogin(@RequestBody LoginPayload loginPayload){

        User user=userRepository.findByUserName(loginPayload.getUserName());

        if (user==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginPayload.getUserName(),loginPayload.getPassword()));

//        create
        String token=jwtTokenProvider.createToken(user.getUserName(),user.getRoleList());
        if(token==null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Nimadir xato");

        Map<String,Object> result=new HashMap<>();
        result.put("status",true);
        result.put("userName",user.getUserName());
        result.put("token",token);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result> getTest(@PathVariable Long id){
        Result result=roleService.getRole(id);
        return ResponseEntity.status(result.isStatus()?200:404).body(result);
    }

}
