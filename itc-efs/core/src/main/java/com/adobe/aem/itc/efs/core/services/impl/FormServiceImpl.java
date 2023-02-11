package com.adobe.aem.itc.efs.core.services.impl;
import java.util.HashMap;
import java.util.Map;
import javax.jcr.Node;
import javax.jcr.Session;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.aem.itc.efs.core.services.EmailService;
import com.adobe.aem.itc.efs.core.services.FormConf;
import com.adobe.aem.itc.efs.core.services.FormService;
import com.day.cq.commons.jcr.JcrUtil;
@Component(service = FormService.class, immediate=true)
@Designate(ocd = FormConf.class)
public class FormServiceImpl implements FormService{
	private static final Logger LOG=LoggerFactory.getLogger(FormServiceImpl.class);
	String path;
	@Reference
	private ResourceResolverFactory resolverFactory;
	@Reference
	EmailService emailService;
	@Activate
	  public void activate(FormConf conf) {
		 path=conf.pathName();
		  }
	public void storeCustomerData(HashMap<String, String> hmap) {
	ResourceResolver resolver;
	try {
		final Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put(ResourceResolverFactory.SUBSERVICE,"itc-service-user");
        resolver = resolverFactory.getServiceResourceResolver(paramMap);
  		Session session=resolver.adaptTo(Session.class);
		Node node=null;
		if(!session.nodeExists(path)) {
		node = JcrUtil.createPath(path, "nt:unstructured", session);
		session.save();
		}
		Node parentNode = session.getNode(path);
		Node childNode = parentNode.addNode(hmap.get("first-name"), "nt:unstructured");
		childNode.setProperty("fn",hmap.get("first-name"));
		childNode.setProperty("ln",hmap.get("last-name"));
		childNode.setProperty("em",hmap.get("email"));
		childNode.setProperty("pn",hmap.get("phone-number"));
		session.save();
		LOG.info("user added");
		emailService.sendEmail("Email has sent");
	} catch (Exception e) {
		LOG.error("===unable to create node===",e);
	}
	
}
}
