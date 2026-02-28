package com.SpringStudy.SpringProject.week3.day24.morning.jwt;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("login")
    public String login(@RequestBody AuthRequest authRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUserName(),
                        authRequest.getPassword()
                )
        );

        return jwtService.generateToken(authRequest.getUserName());

    }


}
