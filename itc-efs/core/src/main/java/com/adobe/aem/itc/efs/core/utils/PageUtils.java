package com.adobe.aem.itc.efs.core.utils;

import static com.adobe.cq.social.community.api.CommunityConstants.CONTENT_ROOT_PATH;
import static com.day.cq.wcm.foundation.List.URL_EXTENSION;
import static org.apache.commons.lang3.StringUtils.*;


public class PageUtils {
	
	  public static final String DAM_ROOT_NODE = "/content/dam";

	    public static final String FORWARD_SLASH = "/";

	    private static final String DOUBLE_SLASH = "//";

	    private PageUtils() {
	        // Default constructor
	    }

	    public static boolean isDamPath(String link) {
	        return startsWith(link, DAM_ROOT_NODE);
	    }

	    public static String appendHtmlToInternalLink(String link) {
	        if (isBlank(link) || endsWith(link, URL_EXTENSION) || !isInternalPagePath(link) || endsWith(link,
	                FORWARD_SLASH)) {
	            return link;
	        }
	        return link + URL_EXTENSION;
	    }

	    public static boolean isInternalPagePath(String link) {
	        return startsWith(link, CONTENT_ROOT_PATH) && !isDamPath(link);
	    }

	    public static boolean isInternalPath(String link) {
	        return startsWith(link, FORWARD_SLASH) && !startsWith(link, DOUBLE_SLASH);
	    }

}
