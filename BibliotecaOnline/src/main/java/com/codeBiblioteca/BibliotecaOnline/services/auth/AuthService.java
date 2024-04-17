package com.codeBiblioteca.BibliotecaOnline.services.auth;

import com.codeBiblioteca.BibliotecaOnline.dto.SignupRequest;
import com.codeBiblioteca.BibliotecaOnline.dto.UserDto;
import org.springframework.stereotype.Service;


public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);
}
