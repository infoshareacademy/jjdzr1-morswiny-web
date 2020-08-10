package com.isa.morswiny.usersDao;

import com.isa.morswiny.users.User;
import javax.ejb.Local;
import java.util.List;

@Local
public interface UserCRUDRepositoryInterface {
    List<User> getUsersList();

    void addUser(User user);
}
