package com.codeBiblioteca.BibliotecaOnline.dto;

import com.codeBiblioteca.BibliotecaOnline.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;
    private Long userId;
    private UserRole userRole;

}
