package com.adobe.aem.itc.efs.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;


import static  com.adobe.aem.itc.efs.core.utils.PageUtils.appendHtmlToInternalLink;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.apache.sling.models.annotations.DefaultInjectionStrategy.OPTIONAL;
@Model(adaptables = Resource.class, defaultInjectionStrategy = OPTIONAL)
public class LinkModel {
	

    @Inject
    private String link;

    @Inject
    private String linkText;

    @Inject
    @Default(booleanValues = false)
    private boolean targetNewWindow;

    @Inject
    private String icon;

    @Inject
    private String iconUrl;

    @Inject
    private String altText;

    @Inject
    private String title;

    @Inject
    private String description;

    @Inject
    private String overLineText;

    /**
     * Post construct init method
     */
    @PostConstruct
    public void init() {
        link = isNotEmpty(link) ? appendHtmlToInternalLink(link) : link;
    }

    public String getLink() {
        return link;
    }

    public String getLinkText() {
        return linkText;
    }

    public boolean isTargetNewWindow() {
        return targetNewWindow;
    }

    public String getAltText() {
        return altText;
    }

    public String getIcon() {
        return icon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getOverLineText() {
        return overLineText;
    }

}
