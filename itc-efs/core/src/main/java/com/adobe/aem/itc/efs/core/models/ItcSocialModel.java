package com.adobe.aem.itc.efs.core.models;

import static java.util.Collections.emptyList;
import static org.apache.commons.collections4.CollectionUtils.isEmpty;
import static org.apache.sling.models.annotations.DefaultInjectionStrategy.OPTIONAL;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = OPTIONAL)
public class ItcSocialModel {
	
	  @ChildResource
	    private List<LinkModel> socialLinks;

	    @ValueMapValue
	    private String label;

	    @PostConstruct
	    public void init() {
	        socialLinks = !isEmpty(socialLinks) ? socialLinks.stream().filter(Objects::nonNull).collect(Collectors.toList()) : emptyList();
	    }

	    public List<LinkModel> getSocialLinks() {
	        return socialLinks;
	    }

	    public String getLabel() {
	        return label;
	    }

}
