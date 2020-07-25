package com.isa.morswiny.usersDao;

import com.isa.morswiny.users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class UserDataManagement {

    private static final Logger STDOUT = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void setDefaultImage(User user){
        try {
            user.setMyPicture(ImageIO.read(new File("src/main/webapp/Images/default-user-icon-4.jpg")));
        } catch (IOException e){
            STDOUT.error("Default image not found!");
        }
    }
}
