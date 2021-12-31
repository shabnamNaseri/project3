package controller;

import model.User;
import java.sql.*;
import java.util.ArrayList;

public class DataBase
{
    private static Connection connection;
    private static Statement statement;

    private DataBase(){}


    public static void createConnection()
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/Messenger", "root",
                    "anssHpassword9474");
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection()
    {
        try {
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int createUser(User user) throws SQLException
    {
        createConnection();

        statement.execute(String.format("insert into List(Name,LastName,Username,Password,HashPassword,PhoneNumber)"
                        + "values('%s','%s','%s','%s','%d','%s')" ,user.getName(),user.getLastName(),user.getUserName(),
                user.getPassword(),user.getHashPassword(),user.getPhoneNumber()), statement.RETURN_GENERATED_KEYS);


        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        int id = resultSet.getInt(1);

        closeConnection();
        return id;
    }

    public static ArrayList<User> getUsers() throws Exception
    {
        createConnection();

        ResultSet result = statement.executeQuery("select * from List");
        ArrayList<User> users = new ArrayList<>();
        while (result.next())
        {
            users.add(new User(result.getInt("Id"),result.getString("Name")
                    , result.getString("LastName"),result.getString("Username")
                    , result.getString("Password") , result.getInt("HashPassword")
                    , result.getString("PhoneNumber")));
        }

        closeConnection();

        return users;
    }

}
