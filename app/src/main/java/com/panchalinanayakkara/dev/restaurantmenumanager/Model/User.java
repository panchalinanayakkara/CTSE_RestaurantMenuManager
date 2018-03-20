package com.panchalinanayakkara.dev.restaurantmenumanager.Model;

public class User {
    private String name;
    private String password;

    public User()
    {

    }

    public User(String name, String password)
    {
        name =  name;
        password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName()
    {
        name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword()
    {
        password = password;
    }
}
