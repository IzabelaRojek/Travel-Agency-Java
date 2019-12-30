package com.kodilla.travelagency.domain.bing.image;

public class VideoObject {
    private String duration;

    public Creator creator;

    public String getDuration ()
    {
        return duration;
    }

    public void setDuration (String duration)
    {
        this.duration = duration;
    }

    public Creator getCreator ()
    {
        return creator;
    }

    public void setCreator (Creator creator)
    {
        this.creator = creator;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [duration = "+duration+", creator = "+creator+"]";
    }
}
