package com.nickglas.gc.Code.generation.repositories;

import com.nickglas.gc.Code.generation.models.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);
}
