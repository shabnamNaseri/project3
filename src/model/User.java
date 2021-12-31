package model;

import controller.DataBase;
import controller.MainPageController;

import javax.swing.text.TableView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class User{

    private  int id = -1;
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private int hashPassword;
    private String phoneNumber;
    private static ArrayList<User> userArrayList = new ArrayList<>();
    private MainPageController mainPageController;

    public  User(MainPageController mainPageController)
    {this.mainPageController = mainPageController;}


    public User(int id,String name, String lastName, String userName, String password, int passwordHash, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.hashPassword = passwordHash;
        this.phoneNumber = phoneNumber;
    }

    public User(String name ,String lastName)
    {
        this.name = name;
        this.lastName = lastName;
    }

    public User() {}

    public User(String name, String lastName, String userName, String password, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public int getId()
    {return id;}

    public void setId(int id)
    {this.id = id;}

    public int getHashPassword()
    {
        return hashPassword;
    }

    public void setHashPassword(int hashPassword)
    {this.hashPassword = hashPassword;}

    public String getName()
    {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName()
    {return lastName;}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName()
    {return userName;}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber()
    {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber)
    {this.phoneNumber = phoneNumber;}

    public static ArrayList<User> getUserArrayList()
    {return userArrayList;}

    public void setUserArrayList(ArrayList<User> userArrayList) {
        User.userArrayList = userArrayList;
    }

    public static ArrayList<User> getUsers()
    {
        try {
            return DataBase.getUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveuser() throws Exception {
        try {
            id = DataBase.createUser(this);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUserTable()
    {
        mainPageController.getTableview().getItems().addAll(Objects.requireNonNull(getUsers()));
    }


}
