package com.nickglas.gc.Code.generation.interfaces;

import com.nickglas.gc.Code.generation.models.AppRole;

import java.util.List;

public interface IRoleService {
    List<AppRole> getRoles();
    AppRole saveRole(AppRole role);
}
