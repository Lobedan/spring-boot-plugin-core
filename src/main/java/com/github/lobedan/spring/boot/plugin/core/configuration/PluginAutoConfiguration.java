package com.github.lobedan.spring.boot.plugin.core.configuration;

import com.github.lobedan.spring.boot.plugin.core.DefaultPluginRegistry;
import com.github.lobedan.spring.boot.plugin.core.EnablePlugin;
import com.github.lobedan.spring.boot.plugin.core.PluginRegistry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by svenklemmer on 10.11.14.
 *
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration Auto-configuration} for Spring Boot Plugin Engine
 */
@Configuration
@ConditionalOnJava(value = ConditionalOnJava.JavaVersion.SIX, range = ConditionalOnJava.Range.EQUAL_OR_NEWER)
@ConditionalOnClass(EnablePlugin.class)
//@ConditionalOnProperty(prefix = "spring.plugin", name = "path") //TODO: enable with new spring boot release 1.2.0
@EnableConfigurationProperties(PluginProperties.class)
public class PluginAutoConfiguration {
  private static final Log LOGGER = LogFactory.getLog(PluginAutoConfiguration.class);

  @Autowired
  PluginProperties properties;

  @Bean
  public PluginRegistry pluginRegistry() {
    return DefaultPluginRegistry.create();
  }
}
