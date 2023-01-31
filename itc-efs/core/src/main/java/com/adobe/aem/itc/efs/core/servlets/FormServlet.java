package com.adobe.aem.itc.efs.core.servlets;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.adobe.aem.itc.efs.core.services.FormService;
@Component(service=Servlet.class)
@SlingServletPaths(
		value="/bin/form"
		)
public class FormServlet extends SlingAllMethodsServlet{
@Reference
FormService fmService;
@Override
protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse res)
throws ServletException, IOException{
	String firstName=req.getParameter("first-name");
	String lastName=req.getParameter("last-name");
	String emailAddress=req.getParameter("email");
	String phoneNumber=req.getParameter("phone-number");
	HashMap<String, String> mapValues = new HashMap<String, String>();
	mapValues.put("first-name", firstName);
	mapValues.put("last-name", lastName);
	mapValues.put("email", emailAddress);
	mapValues.put("phone-number", phoneNumber);
	fmService.storeCustomerData(mapValues);
	res.setContentType("text/html");
	res.getWriter().append("Customer details updated");
	}
}
