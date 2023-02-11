package com.adobe.aem.itc.efs.core.services;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
@ObjectClassDefinition(
		name="Email Configuration",
		description="Email fields configuration"
			)
public @interface EmailConf {
	@AttributeDefinition(
			 name="To email user",
			 description="Name of the email user",
			 type=AttributeType.STRING)
public String toEmail();
	@AttributeDefinition(
			 name="From email user",
			 description="Name of the from email user",
			 type=AttributeType.STRING)
public String fromEmail();
	@AttributeDefinition(
			 name="Password for email",
			 description="Email password",
			 type=AttributeType.STRING)
public String password();
}
