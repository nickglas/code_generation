package com.nickglas.gc.Code.generation.appRunner;

import com.nickglas.gc.Code.generation.models.AppRole;
import com.nickglas.gc.Code.generation.models.AppUser;
import com.nickglas.gc.Code.generation.services.RoleService;
import com.nickglas.gc.Code.generation.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandRunner implements ApplicationRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        roleService.saveRole(new AppRole("USER"));
        roleService.saveRole(new AppRole("EMPLOYEE"));

        userService.saveUser(new AppUser("Nick Glas", "nick", "1234"));
        userService.saveUser(new AppUser("Peter Piet", "peter", "1234"));

        userService.addRoleToUser("nick", "USER");
        userService.addRoleToUser("nick", "EMPLOYEE");

        userService.addRoleToUser("peter", "USER");



    }
}
