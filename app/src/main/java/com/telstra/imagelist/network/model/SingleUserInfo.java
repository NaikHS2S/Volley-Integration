package com.telstra.imagelist.network.model;

public class SingleUserInfo
{
    // Added setter to update SingleUserInfo while running test cases .

    private String title;

    private String description;

    private String imageHref;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }

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

