package com.isa.morswiny.usersDao;

import com.isa.morswiny.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.time.*;

@Stateless
public class UserDataManagement implements UserCRUDRepositoryInterface {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void setDefaultImage(User user){
        try {
            user.setMyPicture(ImageIO.read(new File("src/main/webapp/Images/default-user-icon-4.jpg")));
        } catch (IOException e){
            STDOUT.error("Default image not found!");
        }
    }

    @Override
    public void addUser(User user) {
        List<User> userList = UserRepository.getRepository();
        userList.add(user);
    }

    @Override
    public List<User> getUsersList () {
        return UserRepository.getRepository();
    }




}
