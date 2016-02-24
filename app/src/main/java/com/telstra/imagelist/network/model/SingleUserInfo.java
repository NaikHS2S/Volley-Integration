package com.telstra.imagelist.network.model;

public class SingleUserInfo
{
    // Added to initialize SingleUserInfo while running test cases .

    public SingleUserInfo(String title, String description, String imageHref) {
        this.title = title;
        this.description = description;
        this.imageHref = imageHref;
    }

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

