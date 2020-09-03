package com.isa.morswiny.usersDao;

import com.isa.morswiny.users.User;
import com.isa.morswiny.users.UserType;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserRegistrationDao {

    public int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USER_SQL = "INSERT INTO EventsUsers" +
                "(Name, Surname, Login, Email, Password, Gender, Nationality, " +
                "UserType, Birthday, RegistrationTime) VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/morswinyweb?useSSL=false", "root", "");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, String.valueOf(user.getUserGender()));
            preparedStatement.setString(7, String.valueOf(user.getUserNationality()));
            preparedStatement.setString(8, String.valueOf(user.getUserType()));
            preparedStatement.setString(9, String.valueOf(user.getBirthday()));
            preparedStatement.setString(10, String.valueOf(LocalDateTime.now()));

            System.out.println(preparedStatement);

            result = preparedStatement.executeUpdate();

/*    try (ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM EventsUsers"))
    {
        if (resultSet.next()) System.out.println(resultSet.getString(4));
        System.out.println(resultSet);
    }
 */

        } catch (SQLException ex) {
            for (Throwable throwable : ex)
                throwable.printStackTrace();
        }

        return result;
    }
}
