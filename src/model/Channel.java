package model;

import java.util.ArrayList;

public class Channel {
    private String ChannelName;
    static ArrayList<Channel> channelArrayList = new ArrayList<>();
    static ArrayList<User> channelUser = new ArrayList<>();

    public Channel(String channelName) {
        ChannelName = channelName;
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }

    public  ArrayList<Channel> getChannelArrayList() {
        return channelArrayList;
    }

    public static void setChannelArrayList(ArrayList<Channel> channelArrayList) {
        Channel.channelArrayList = channelArrayList;
    }

    public  ArrayList<User> getChannelUser() {
        return channelUser;
    }

    public static void setChannelUser(ArrayList<User> channelUser) {
        Channel.channelUser = channelUser;
    }
}

