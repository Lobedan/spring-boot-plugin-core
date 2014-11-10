package com.github.lobedan.spring.boot.plugin.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by svenklemmer on 10.11.14.
 *
 * gets properties from application.properties
 */
@ConfigurationProperties(prefix = "spring.plugin")
public class PluginProperties {

  private String path;

  public String getPath() {
    return path;
  }

  public void setPath(String aPath) {
    path = aPath;
  }
}
