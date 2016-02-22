package com.telstra.imagelist.network.model;

/**
 * Created by computer on 2/18/2016.
 */
public class SingleUserInfo
{
    private String title;

    private String description;

    private String imageHref;

    public String getTitle ()
    {
        return title;
    }

    public String getDescription ()
    {
        return description;
    }

    public String getImageHref ()
    {
        return imageHref;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", description = "+description+", imageHref = "+imageHref+"]";
    }
}

