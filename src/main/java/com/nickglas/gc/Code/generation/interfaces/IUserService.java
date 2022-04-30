package com.nickglas.gc.Code.generation.interfaces;

import com.nickglas.gc.Code.generation.models.AppUser;

import java.util.List;

public interface IUserService {
    AppUser saveUser(AppUser user);
    AppUser getUser(String username);
    List<AppUser> getUsers();
    void addRoleToUser(String username, String roleName);
}
