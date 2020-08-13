package com.isa.morswiny.usersDao;

import com.isa.morswiny.users.User;
import javax.ejb.Local;
import java.util.Set;

@Local
public interface UserCRUDRepositoryInterface {
    Set<User> getUsersList();

    void addUser(User user);
}
