package com.thinkenterprise.graphqlio.server.wsf;


import java.lang.annotation.*;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(GraphQLIOLibraryWsfConfiguration.class)
@Configuration
public @interface EnableGraphQLIOWsfLibraryModule {
}