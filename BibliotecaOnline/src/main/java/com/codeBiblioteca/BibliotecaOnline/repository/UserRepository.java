package com.codeBiblioteca.BibliotecaOnline.repository;

import com.codeBiblioteca.BibliotecaOnline.entity.User;
import com.codeBiblioteca.BibliotecaOnline.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);

    Optional<User> findByUserRole(UserRole userRole);
}
