package com.nickglas.gc.Code.generation.services;

import com.nickglas.gc.Code.generation.interfaces.IRoleService;
import com.nickglas.gc.Code.generation.models.AppRole;
import com.nickglas.gc.Code.generation.repositories.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final RoleRepo roleRepo;

    @Override
    public List<AppRole> getRoles() {
        return roleRepo.findAll();
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepo.save(role);
    }
}
