package com.adobe.aem.itc.efs.core.models;
import java.util.ArrayList;
import java.util.List;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
@Model(adaptables=Resource.class, defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class InformationModel {

	/*
	 * @Inject private Resource quickLinks;
	 * 
	 */
	@ChildResource
	private final List<LinksModel> quickLinks = new ArrayList<>();
	public List<LinksModel> getQuickLinks() {
		List<LinksModel> linkscopy = new ArrayList<LinksModel>();
		linkscopy.addAll(quickLinks);
		return linkscopy;

	}

}
