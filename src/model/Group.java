package model;

import java.util.ArrayList;

public class Group {
    private String GroupName;
    static ArrayList<Group> groupArrayList = new ArrayList<>();
    static ArrayList<User> groupUser = new ArrayList<>();

    public Group(String groupName) {
        GroupName = groupName;
    }


    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public  ArrayList<Group> getGroupArrayList() {
        return groupArrayList;
    }

    public static void setGroupArrayList(ArrayList<Group> groupArrayList) {
        Group.groupArrayList = groupArrayList;
    }

    public  ArrayList<User> getGroupUser() {
        return groupUser;
    }

    public static void setGroupUser(ArrayList<User> groupUser) {
        Group.groupUser = groupUser;
    }
}
