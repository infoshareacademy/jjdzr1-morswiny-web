package com.isa.morswiny.usersDao;

import com.isa.morswiny.users.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.isa.morswiny.users.UserType;

public class UserRepository {

    private static Set<User> usersRepository = new HashSet<>();

    public static Set<User> getRepository() {
        if (usersRepository.size() == 0) {
            fillRepositoryWithAdmins();
        }
        return usersRepository;
    }

    private static void fillRepositoryWithAdmins() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Kuba");
        user1.setSurname("Bieńkowski");
        user1.setLogin("kuba");
        user1.setEmail("kuba@com.pl");
        user1.setPassword("kuba1234");
        user1.setBirthday(LocalDate.parse("2020-01-01",DateTimeFormatter.ISO_LOCAL_DATE));
        user1.setUserType(UserType.ADMIN);
        usersRepository.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("Tomek");
        user2.setSurname("Miecielica");
        user2.setLogin("tomek");
        user2.setEmail("tomek@com.pl");
        user2.setPassword("tomek1234");
        user2.setBirthday(LocalDate.parse("2020-01-02",DateTimeFormatter.ISO_LOCAL_DATE));
        user2.setUserType(UserType.ADMIN);
        usersRepository.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("Mateusz");
        user3.setSurname("Stopyra");
        user3.setLogin("mateusz");
        user3.setEmail("mateusz@com.pl");
        user3.setPassword("mateusz1234");
        user3.setBirthday(LocalDate.parse("2020-01-03",DateTimeFormatter.ISO_LOCAL_DATE));
        user3.setUserType(UserType.ADMIN);
        usersRepository.add(user3);

        User user4 = new User();
        user4.setId(4);
        user4.setName("Agata");
        user4.setSurname("Sudoł");
        user4.setLogin("agata");
        user4.setEmail("agata@com.pl");
        user4.setPassword("agata1234");
        user4.setBirthday(LocalDate.parse("2020-01-04",DateTimeFormatter.ISO_LOCAL_DATE));
        user4.setUserType(UserType.ADMIN);
        usersRepository.add(user4);

        User user5 = new User();
        user5.setId(5);
        user5.setName("Przemek");
        user5.setSurname("Zieliński");
        user5.setLogin("przemek");
        user5.setEmail("przemek@com.pl");
        user5.setPassword("przemek1234");
        user5.setBirthday(LocalDate.parse("2020-01-05",DateTimeFormatter.ISO_LOCAL_DATE));
        user5.setUserType(UserType.ADMIN);
        usersRepository.add(user5);

    }

    public static boolean contains(User user) {
        Set<User> repository = getRepository();
        for (User userFromSet : repository) {
            if (userFromSet.getId().equals(user.getId())) {
                return true;
            }
        }
        return false;
    }

}
