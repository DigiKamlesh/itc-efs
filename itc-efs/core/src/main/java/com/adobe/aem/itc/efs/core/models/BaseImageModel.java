package com.adobe.aem.itc.efs.core.models;


import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.sling.models.annotations.DefaultInjectionStrategy.OPTIONAL;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.via.ResourceSuperType;

import com.adobe.cq.wcm.core.components.models.Image;
@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, defaultInjectionStrategy = OPTIONAL)
public abstract class BaseImageModel implements ImageModel {

    @Self
    @Via(type = ResourceSuperType.class)
    private Image image;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String description;

    @ValueMapValue
    private String alt;

    @ValueMapValue
    private String fileReferenceMobile;
    
    @ValueMapValue
    private String button1;
    
    @ValueMapValue
    private String linkurl1;
    
	@ValueMapValue
    private String buttontextOne;

    public String getButtontextOne() {
		return buttontextOne;
	}

	public void setButtontextOne(String buttontextOne) {
		this.buttontextOne = buttontextOne;
	}

	@Override
    public String getTitle() {
        return title;
    }

    public String getButton1() {
		return button1;
	}

	public String getLinkurl1() {
		return linkurl1;
	}	

	@Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getImage() {
        return image.getSrc();
    }

    @Override
    public String getAltText() {
        return isNotBlank(alt) ? alt : image.getAlt();
    }

    @Override
    public boolean isImageEmpty() {
        return isEmpty(image.getFileReference());
    }

    @Override
    public String getMobileImage() {
        return fileReferenceMobile;
    }

	

}
