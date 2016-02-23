package com.telstra.imagelist.network.model;

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
        return "Class [title = "+title+", description = "+description+", imageHref = "+imageHref+"]";
    }
}

