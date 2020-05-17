package com.jpmc.custom.initilizer;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.metadata.InitializrMetadataBuilder;
import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.metadata.InitializrProperties;
import io.spring.initializr.web.support.DefaultInitializrMetadataProvider;
import io.spring.initializr.web.support.InitializrMetadataUpdateStrategy;

@Configuration
@EnableConfigurationProperties(CustomInitializrProperties.class)
public class CustomInitializrConfiguration {
	
	@Bean
	public InitializrMetadataProvider initializrMetadataProvider(InitializrProperties properties,
			CustomInitializrProperties customProperties,
			InitializrMetadataUpdateStrategy initializrMetadataUpdateStrategy) {
		InitializrMetadata metadata = InitializrMetadataBuilder.fromInitializrProperties(customProperties.getInitializr()).withInitializrProperties(properties, true).build();
		return new DefaultInitializrMetadataProvider(metadata, initializrMetadataUpdateStrategy);
	}
	
/*	@Bean
	public InitializrMetadataUpdateStrategy initializrMetadataUpdateStrategy() {
	    return (metadata) -> metadata;
	}*/
	
}
