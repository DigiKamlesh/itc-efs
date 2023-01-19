package com.adobe.aem.itc.efs.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables= {Resource.class} , defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class IctLogo {

    @ValueMapValue
	private String fileReference;

	public String getFileReference() {
		return fileReference;
	}
    
  	
	
	
}
