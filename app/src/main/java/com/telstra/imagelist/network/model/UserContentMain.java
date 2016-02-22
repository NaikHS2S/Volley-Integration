package com.telstra.imagelist.network.model;

import java.util.ArrayList;

/**
 * Created by computer on 2/18/2016.
 */

public class UserContentMain
{
    public void setTitle(String title) {
        this.title = title;
    }

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
        return "ClassPojo [title = "+title+", rows = "+rows+"]";
    }
}
