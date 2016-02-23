package com.telstra.imagelist.network.model;

import java.util.ArrayList;

public class UserContentMain
{

    private String title;

    private ArrayList<SingleUserInfo> rows;

    public String getTitle ()
    {
        return title;
    }

    public ArrayList<SingleUserInfo>  getRows ()
    {
        return rows;
    }

    @Override
    public String toString()
    {
        return "Class [title = "+title+", rows = "+rows+"]";
    }
}
