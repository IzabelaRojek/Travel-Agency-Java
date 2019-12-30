package com.kodilla.travelagency.domain.bing.image;

public class InsightsMetadata {

    private String pagesIncludingCount;

    private String availableSizesCount;

    public String getPagesIncludingCount ()
    {
        return pagesIncludingCount;
    }

    public void setPagesIncludingCount (String pagesIncludingCount)
    {
        this.pagesIncludingCount = pagesIncludingCount;
    }

    public String getAvailableSizesCount ()
    {
        return availableSizesCount;
    }

    public void setAvailableSizesCount (String availableSizesCount)
    {
        this.availableSizesCount = availableSizesCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [pagesIncludingCount = "+pagesIncludingCount+", availableSizesCount = "+availableSizesCount+"]";
    }
}
