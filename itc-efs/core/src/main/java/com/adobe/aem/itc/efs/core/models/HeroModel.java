package com.adobe.aem.itc.efs.core.models;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import static org.apache.sling.models.annotations.DefaultInjectionStrategy.OPTIONAL;
import org.apache.commons.lang3.StringUtils;


	@Model(adaptables = {Resource.class, SlingHttpServletRequest.class}, defaultInjectionStrategy = OPTIONAL)
	public class HeroModel extends BaseImageModel {

	    @ValueMapValue
	    @Default(values = "big_hero")
	    private String heroType;

	    @ValueMapValue
	    private String subTitle;
	    
	    @ValueMapValue
	    @Default(values = "button")
	    private String button1;
	    
	    
	    @ValueMapValue
		private String linkURL1;
	    
		@ValueMapValue
	    private String buttontextOne;
	    
	    

	    public String getButtontextOne() {
			return buttontextOne;
		}

		public String getHeroType() {
	        return heroType;
	    }

	    public String getSubTitle() {
	        return subTitle;
	    }
	    
	    public String getButton1() {	
			return button1;
		}
	    
	    public String getLinkURL1() {
			return StringUtils.join(linkURL1, ".html");
		}

		@Override
		public String buttontextOne() {
			// TODO Auto-generated method stub
			return null;
		}


}