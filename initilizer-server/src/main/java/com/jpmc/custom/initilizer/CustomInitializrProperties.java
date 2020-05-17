package com.jpmc.custom.initilizer;

import io.spring.initializr.metadata.InitializrProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "prd")
public class CustomInitializrProperties {

	@NestedConfigurationProperty
	private final InitializrProperties initializr =  new InitializrProperties();

	public InitializrProperties getInitializr() {
		return initializr;
	}
}