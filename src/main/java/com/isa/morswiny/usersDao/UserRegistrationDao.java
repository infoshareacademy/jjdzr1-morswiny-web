package com.isa.morswiny.usersDao;

import com.isa.morswiny.users.User;
import com.isa.morswiny.users.UserType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserRegistrationDao {

    public int registerUser (User user) throws ClassNotFoundException {
        String INSERT_USER_SQL = "INSERT INTO EventsUsers" +
                "(ID, Name, Surname, Login, Email, Password, Gender, Nationality, " +
                "UserType, Birthday, RegistrationTime) VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

int result = 0;

Class.forName("com.mysql.cj.jdbc.Driver");

try (Connection connection = DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/morswinyweb?useSSL=false","root","");
     PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL))
{
preparedStatement.setInt(1,1);
preparedStatement.setString(2,user.getName());
preparedStatement.setString(3,user.getSurname());
preparedStatement.setString(4,user.getLogin());
preparedStatement.setString(5,user.getEmail());
preparedStatement.setString(6,user.getPassword());
preparedStatement.setString(7,String.valueOf(user.getUserGender()));
preparedStatement.setString(8,String.valueOf(user.getUserNationality()));
preparedStatement.setString(9,String.valueOf(user.getUserType()));
preparedStatement.setString(10,String.valueOf(user.getBirthday()));
preparedStatement.setString(11,String.valueOf(LocalDateTime.now()));

    System.out.println(preparedStatement);

    result = preparedStatement.executeUpdate();

} catch (SQLException e) {
    e.printStackTrace();
}
return result;
    }
}
