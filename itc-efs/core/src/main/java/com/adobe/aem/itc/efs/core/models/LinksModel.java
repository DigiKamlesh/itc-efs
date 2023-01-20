package com.adobe.aem.itc.efs.core.models;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { Resource.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinksModel {

	@ValueMapValue
	@Default(values = StringUtils.EMPTY)
	private String linkLabel;

	@ValueMapValue
	private String linkURL;

	public String getLinkLabel() {
		return linkLabel;
	}

	public String getLinkURL() {
		return StringUtils.join(linkURL, ".html");
	}

}