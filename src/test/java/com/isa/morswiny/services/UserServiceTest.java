package com.isa.morswiny.services;

import com.isa.morswiny.Dao.UserDao;
import com.isa.morswiny.dto.UserDto;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserDao userDao;

    @Mock
    UserService userService;

    @InjectMocks
    UserService getUserService;


    @Test
    void userToDtoTest(){

        User user = new User();
        user.setEmail("email");
        user.setUserId(1);
        user.setPassword("password");
        user.setName("name");
        user.setSurname("surname");

        Assertions.assertNotNull(UserService.userToDto(user));

    }

    @Test
    void userDtoToUserTest(){

        UserDto userDto = new UserDto();
        userDto.setEmail("email");
        userDto.setId(1);
        userDto.setPassword("password");
        userDto.setName("name");
        userDto.setSurname("surname");

        Assertions.assertNotNull(UserService.dtoToUser(userDto));

    }

    @Test
    void getUserDtoTest(){

        //given
        UserDto userDto = new UserDto();
        userDto.setId(1);
        userDto.setName("user");

        //when
        when(userService.getUserDto(any(Integer.class))).thenReturn(null);
        when(userService.getUserDto(userDto.getId())).thenReturn(userDto);
        UserDto resultRandom = userService.getUserDto(2);
        UserDto resultUser = userService.getUserDto(userDto.getId());

        //then
        Assertions.assertEquals(resultRandom, null);
        Assertions.assertEquals(resultUser,userDto);

    }


    @Test
    void getAllTest(){

        UserDto userDto1 = new UserDto();
        userDto1.setId(1);
        userDto1.setName("user1");

        UserDto userDto2 = new UserDto();
        userDto2.setId(2);
        userDto2.setName("user2");

        List<UserDto> usersDto = new ArrayList<>();
        usersDto.add(userDto1);
        usersDto.add(userDto2);

        when(userService.getAll()).thenReturn(usersDto);

        Assertions.assertEquals(usersDto,userService.getAll());

    }

    @Test
    void getByEmailTest(){

        when(userService.getByEmail(null)).thenThrow(NullPointerException.class);

        Assertions.assertThrows(NullPointerException.class, () -> userService.getByEmail(null));

    }

    @Test
    void saveUserTest(){

        User user = new User();
        user.setName("TestName");

        when(userDao.save(any(User.class))).thenReturn(new User());
        User created = userDao.save(user);
        UserDto createdDto = getUserService.save(UserService.userToDto(user));

        Assertions.assertSame(createdDto.getName(), created.getName());
    }

    @Test
    void deleteUserTest(){

        doThrow(new NullPointerException("User not found")).when(userService).delete(null);
        Assertions.assertThrows(NullPointerException.class,() -> userService.delete(null));

    }
}
