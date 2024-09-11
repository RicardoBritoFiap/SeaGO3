package com.fiap.seago.empresa.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fiap.seago.empresa.token.Credentials;
import com.fiap.seago.empresa.token.Token;
import com.fiap.seago.empresa.token.TokenService;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    public Token login (Credentials credentials) {
        var user = userRepository.findByUsername(credentials.username())
                .orElseThrow( () -> new RuntimeException("Access denied") );

        if ( ! passwordEncoder.matches(credentials.password(), user.getPassword()) )
            throw new RuntimeException("Access denied");

        return tokenService.createToken(credentials.username());
    }

}