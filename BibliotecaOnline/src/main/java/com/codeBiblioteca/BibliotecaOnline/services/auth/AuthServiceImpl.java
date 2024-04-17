package com.codeBiblioteca.BibliotecaOnline.services.auth;

import com.codeBiblioteca.BibliotecaOnline.dto.SignupRequest;
import com.codeBiblioteca.BibliotecaOnline.dto.UserDto;
import com.codeBiblioteca.BibliotecaOnline.entity.User;
import com.codeBiblioteca.BibliotecaOnline.enums.UserRole;
import com.codeBiblioteca.BibliotecaOnline.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements  AuthService{

    private final UserRepository userRepository;

    @PostConstruct
    private void createAnAdminAccount(){
        Optional<User> adminAccount = userRepository.findByUserRole(UserRole.ADMIN);
        if(adminAccount.isEmpty()){
            User user = new User();
            user.setEmail("admin@test.com");
            user.setName("Admin");
            user.setUserRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
            System.out.println("Admin account success");

        }else {
            System.out.println("admin already exists ");
        }
    }

    public UserDto createUser(SignupRequest signupRequest){
        if(userRepository.findFirstByEmail(signupRequest.getEmail()).isPresent()){
            throw new EntityExistsException("User already present email " + signupRequest.getEmail());
        }

        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setUserRole(UserRole.CUSTOMER);
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        User createdUser = userRepository.save(user);
        return  createdUser.getUserDto();
    }
}
