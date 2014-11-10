package com.github.lobedan.spring.boot.plugin.core.metadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.apache.commons.logging.LogFactory;

/**
 * Created by svenklemmer on 10.11.14.
 * <p/>
 * holds metadata of a plugin definied in there plugin.json
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PluginMetaData {

  @JsonProperty(value = "name", required = true)
  private String name;

  @JsonProperty(value = "version", required = false)
  private String version;

  @JsonProperty(value = "author", required = true)
  private String author;

  @JsonProperty(value = "description", required = false)
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String aName) {
    name = aName;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String aVersion) {
    version = aVersion;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String aAuthor) {
    author = aAuthor;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String aDescription) {
    description = aDescription;
  }

  @JsonIgnore
  public void print() {
    LogFactory.getLog(PluginMetaData.class)
        .info(new StringBuilder()
                  .append("Name: ").append(name).append("\n")
                  .append("Author: ").append(author).append("\n")
                  .append("Version: ").append(version).append("\n")
                  .append("Descripion: ").append(description).append("\n")
                  .toString());
  }
}
