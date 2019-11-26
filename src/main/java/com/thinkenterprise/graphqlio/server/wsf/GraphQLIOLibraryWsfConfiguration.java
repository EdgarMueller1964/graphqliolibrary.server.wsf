package com.thinkenterprise.graphqlio.server.wsf;



import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = GraphQLIOLibraryWsfConfiguration.class)
public class GraphQLIOLibraryWsfConfiguration {

	
	  private static final Logger logger = LoggerFactory.getLogger(GraphQLIOLibraryWsfConfiguration.class);

	  @PostConstruct
	  public void postConstruct(){
	    logger.info("GraphQLIOLIbrary WSF Module Loaded!");
	  }
}

