package com.nickglas.gc.Code.generation.repositories;

import com.nickglas.gc.Code.generation.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
