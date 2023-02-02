package com.adobe.aem.itc.efs.core.services;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
@ObjectClassDefinition(
		name="Form Configuration",
		description="Path name configuration"
			)
public @interface FormConf{
	@AttributeDefinition(
					 name="Path name",
					 description="Name of the path",
					 type=AttributeType.STRING)
	 public String pathName();
    }
