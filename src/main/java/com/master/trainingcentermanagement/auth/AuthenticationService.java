package com.master.trainingcentermanagement.auth;

import com.master.trainingcentermanagement.config.JwtService;
import com.master.trainingcentermanagement.exception.errors.AppException;
import com.master.trainingcentermanagement.user.Role;
import com.master.trainingcentermanagement.user.User;
import com.master.trainingcentermanagement.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepo repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponse register(RegisterRequest request) {

        Optional<User> optionalUser = repository.findByEmail(request.getEmail());

        if(optionalUser.isPresent()){
            throw new AppException("Email already exists", HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .keywords(request.getKeywords())
                .active(true)
            //    .image(request.getImage().toString())
            //    .role(Role.TRAINER)
                .build();

        repository.save(user);

        String jwtToken = jwtService.generateToken(user);


        return new AuthenticationResponse(user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getRole(), user.getKeywords(),user.getImage(),  jwtToken);
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        var user = repository.findByEmail(request.getEmail())
                .orElseThrow( () -> new AppException("Unknown User", HttpStatus.NOT_FOUND));


        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        }catch (Exception ex){
            throw new AppException("Authentication failed", HttpStatus.BAD_REQUEST);
        }

        String jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getRole(), user.getKeywords(), user.getImage(), jwtToken);
    }
}
