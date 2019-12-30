package com.kodilla.travelagency.domain.bing.image;

public class Value {

    private InsightsMetadata insightsMetadata;

    private String hostPageUrl;

    private Thumbnail thumbnail;

    private String imageId;

    private String isFamilyFriendly;

    private String accentColor;

    private String hostPageFavIconUrl;

    private String imageInsightsToken;

    private String webSearchUrl;

    private String hostPageDomainFriendlyName;

    private String datePublished;

    private String hostPageDisplayUrl;

    private String contentUrl;

    private String contentSize;

    private String name;

    private String width;

    private String encodingFormat;

    private String thumbnailUrl;

    private String height;

    public InsightsMetadata getInsightsMetadata ()
    {
        return insightsMetadata;
    }

    public void setInsightsMetadata (InsightsMetadata insightsMetadata)
    {
        this.insightsMetadata = insightsMetadata;
    }

    public String getHostPageUrl ()
    {
        return hostPageUrl;
    }

    public void setHostPageUrl (String hostPageUrl)
    {
        this.hostPageUrl = hostPageUrl;
    }

    public Thumbnail getThumbnail ()
    {
        return thumbnail;
    }

    public void setThumbnail (Thumbnail thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getImageId ()
    {
        return imageId;
    }

    public void setImageId (String imageId)
    {
        this.imageId = imageId;
    }

    public String getIsFamilyFriendly ()
    {
        return isFamilyFriendly;
    }

    public void setIsFamilyFriendly (String isFamilyFriendly)
    {
        this.isFamilyFriendly = isFamilyFriendly;
    }

    public String getAccentColor ()
    {
        return accentColor;
    }

    public void setAccentColor (String accentColor)
    {
        this.accentColor = accentColor;
    }

    public String getHostPageFavIconUrl ()
    {
        return hostPageFavIconUrl;
    }

    public void setHostPageFavIconUrl (String hostPageFavIconUrl)
    {
        this.hostPageFavIconUrl = hostPageFavIconUrl;
    }

    public String getImageInsightsToken ()
    {
        return imageInsightsToken;
    }

    public void setImageInsightsToken (String imageInsightsToken)
    {
        this.imageInsightsToken = imageInsightsToken;
    }

    public String getWebSearchUrl ()
    {
        return webSearchUrl;
    }

    public void setWebSearchUrl (String webSearchUrl)
    {
        this.webSearchUrl = webSearchUrl;
    }

    public String getHostPageDomainFriendlyName ()
    {
        return hostPageDomainFriendlyName;
    }

    public void setHostPageDomainFriendlyName (String hostPageDomainFriendlyName)
    {
        this.hostPageDomainFriendlyName = hostPageDomainFriendlyName;
    }

    public String getDatePublished ()
    {
        return datePublished;
    }

    public void setDatePublished (String datePublished)
    {
        this.datePublished = datePublished;
    }

    public String getHostPageDisplayUrl ()
    {
        return hostPageDisplayUrl;
    }

    public void setHostPageDisplayUrl (String hostPageDisplayUrl)
    {
        this.hostPageDisplayUrl = hostPageDisplayUrl;
    }

    public String getContentUrl ()
    {
        return contentUrl;
    }

    public void setContentUrl (String contentUrl)
    {
        this.contentUrl = contentUrl;
    }

    public String getContentSize ()
    {
        return contentSize;
    }

    public void setContentSize (String contentSize)
    {
        this.contentSize = contentSize;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getEncodingFormat ()
    {
        return encodingFormat;
    }

    public void setEncodingFormat (String encodingFormat)
    {
        this.encodingFormat = encodingFormat;
    }

    public String getThumbnailUrl ()
    {
        return thumbnailUrl;
    }

    public void setThumbnailUrl (String thumbnailUrl)
    {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [insightsMetadata = "+insightsMetadata+", hostPageUrl = "+hostPageUrl+", thumbnail = "+thumbnail+", imageId = "+imageId+", isFamilyFriendly = "+isFamilyFriendly+", accentColor = "+accentColor+", hostPageFavIconUrl = "+hostPageFavIconUrl+", imageInsightsToken = "+imageInsightsToken+", webSearchUrl = "+webSearchUrl+", hostPageDomainFriendlyName = "+hostPageDomainFriendlyName+", datePublished = "+datePublished+", hostPageDisplayUrl = "+hostPageDisplayUrl+", contentUrl = "+contentUrl+", contentSize = "+contentSize+", name = "+name+", width = "+width+", encodingFormat = "+encodingFormat+", thumbnailUrl = "+thumbnailUrl+", height = "+height+"]";
    }
}
