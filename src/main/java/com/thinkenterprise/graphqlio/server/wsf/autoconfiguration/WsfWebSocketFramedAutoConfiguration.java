package com.thinkenterprise.graphqlio.server.wsf.autoconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WsfWebSocketFramedProperties.class)
@ConfigurationProperties(prefix = "graphqlio.websocketframed")
public class WsfWebSocketFramedAutoConfiguration{

	@Autowired
	private WsfWebSocketFramedProperties properties;
		
}