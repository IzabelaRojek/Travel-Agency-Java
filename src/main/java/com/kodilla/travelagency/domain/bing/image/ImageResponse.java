package com.kodilla.travelagency.domain.bing.image;


public class ImageResponse {

    private String currentOffset;

    private String readLink;

    private String totalEstimatedMatches;

    private QueryContext queryContext;

    private String _type;

    private String webSearchUrl;

    private Instrumentation instrumentation;

    private String nextOffset;

    private Value[] value;

    public String getCurrentOffset ()
    {
        return currentOffset;
    }

    public void setCurrentOffset (String currentOffset)
    {
        this.currentOffset = currentOffset;
    }

    public String getReadLink ()
    {
        return readLink;
    }

    public void setReadLink (String readLink)
    {
        this.readLink = readLink;
    }

    public String getTotalEstimatedMatches ()
    {
        return totalEstimatedMatches;
    }

    public void setTotalEstimatedMatches (String totalEstimatedMatches)
    {
        this.totalEstimatedMatches = totalEstimatedMatches;
    }

    public QueryContext getQueryContext ()
    {
        return queryContext;
    }

    public void setQueryContext (QueryContext queryContext)
    {
        this.queryContext = queryContext;
    }

    public String get_type ()
    {
        return _type;
    }

    public void set_type (String _type)
    {
        this._type = _type;
    }

    public String getWebSearchUrl ()
    {
        return webSearchUrl;
    }

    public void setWebSearchUrl (String webSearchUrl)
    {
        this.webSearchUrl = webSearchUrl;
    }

    public Instrumentation getInstrumentation ()
    {
        return instrumentation;
    }

    public void setInstrumentation (Instrumentation instrumentation)
    {
        this.instrumentation = instrumentation;
    }

    public String getNextOffset ()
    {
        return nextOffset;
    }

    public void setNextOffset (String nextOffset)
    {
        this.nextOffset = nextOffset;
    }

    public Value[] getValue ()
    {
        return value;
    }

    public void setValue (Value[] value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [currentOffset = "+currentOffset+", readLink = "+readLink+", totalEstimatedMatches = "+totalEstimatedMatches+", queryContext = "+queryContext+", _type = "+_type+", webSearchUrl = "+webSearchUrl+", instrumentation = "+instrumentation+", nextOffset = "+nextOffset+", value = "+value+"]";
    }
}
