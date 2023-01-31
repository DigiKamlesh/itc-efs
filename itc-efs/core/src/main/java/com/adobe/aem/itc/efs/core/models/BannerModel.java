package com.adobe.aem.itc.efs.core.models;

import com.adobe.cq.wcm.core.components.models.Image;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BannerModel implements Image {

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String title;

    public String getImage() {
        return image;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @ValueMapValue
    private String description;



}
