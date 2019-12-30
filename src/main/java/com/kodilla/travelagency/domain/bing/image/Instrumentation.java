package com.kodilla.travelagency.domain.bing.image;

public class Instrumentation {

    private String _type;

    public String get_type ()
    {
        return _type;
    }

    public void set_type (String _type)
    {
        this._type = _type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [_type = "+_type+"]";
    }
}
