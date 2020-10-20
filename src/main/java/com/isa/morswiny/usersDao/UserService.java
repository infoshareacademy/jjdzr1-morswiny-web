package com.isa.morswiny.usersDao;

import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.users.User;

public class UserService {

    public static UserDto userToDto (User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setPassword(user.getPassword());
        if (user.getName() != null) {
            userDto.setName(user.getName());
        }
        if (user.getSurname() != null) {
            userDto.setSurname(user.getSurname());
        }
        if (user.getFavourites() != null) {
            userDto.setFavourites(user.getFavourites());
        }

        return userDto;
    }

    public static User dtoToUser{

    }
}
