package com.kodilla.travelagency.domain.bing.image;

public class QueryContext {

    private String alterationDisplayQuery;

    private String alterationOverrideQuery;

    private String originalQuery;

    private String alterationType;

    private String alterationMethod;

    public String getAlterationDisplayQuery ()
    {
        return alterationDisplayQuery;
    }

    public void setAlterationDisplayQuery (String alterationDisplayQuery)
    {
        this.alterationDisplayQuery = alterationDisplayQuery;
    }

    public String getAlterationOverrideQuery ()
    {
        return alterationOverrideQuery;
    }

    public void setAlterationOverrideQuery (String alterationOverrideQuery)
    {
        this.alterationOverrideQuery = alterationOverrideQuery;
    }

    public String getOriginalQuery ()
    {
        return originalQuery;
    }

    public void setOriginalQuery (String originalQuery)
    {
        this.originalQuery = originalQuery;
    }

    public String getAlterationType ()
    {
        return alterationType;
    }

    public void setAlterationType (String alterationType)
    {
        this.alterationType = alterationType;
    }

    public String getAlterationMethod ()
    {
        return alterationMethod;
    }

    public void setAlterationMethod (String alterationMethod)
    {
        this.alterationMethod = alterationMethod;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [alterationDisplayQuery = "+alterationDisplayQuery+", alterationOverrideQuery = "+alterationOverrideQuery+", originalQuery = "+originalQuery+", alterationType = "+alterationType+", alterationMethod = "+alterationMethod+"]";
    }
}
