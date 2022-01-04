package model;

import controller.DataBase;

import java.sql.SQLException;
import java.util.ArrayList;

public class Channel {

    private String channelName;
    static ArrayList<Channel> channelArrayList = new ArrayList<>();
    static ArrayList<User> channelUser = new ArrayList<>();


    public Channel(String channelName)
    {this.channelName = channelName;}

    public String getChannelName()
    {return channelName;}

    public void setChannelName(String channelName)
    {this.channelName = channelName;}

    public static ArrayList<Channel> getChannelArrayList()
    {return channelArrayList;}

    public static void setChannelArrayList(ArrayList<Channel> channelArrayList)
    {Channel.channelArrayList = channelArrayList;}

    public  ArrayList<User> getChannelUser()
    {return channelUser;}

    public static void setChannelUser(ArrayList<User> channelUser)
    {Channel.channelUser = channelUser;}
}

