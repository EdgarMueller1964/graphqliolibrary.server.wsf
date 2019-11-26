package com.thinkenterprise.graphqlio.server.wsf.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@ConfigurationProperties(prefix = "graphqlio.websocketframed")
public class WsfWebSocketFramedProperties {

}