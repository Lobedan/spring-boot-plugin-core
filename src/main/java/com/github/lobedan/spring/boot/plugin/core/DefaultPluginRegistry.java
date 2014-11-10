package com.github.lobedan.spring.boot.plugin.core;

import java.util.HashMap;
import java.util.Map;

import com.github.lobedan.spring.boot.plugin.core.metadata.PluginMetaData;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

/**
 * Created by svenklemmer on 10.11.14.
 */
public class DefaultPluginRegistry implements PluginRegistry {
  private static final Log LOGGER = LogFactory.getLog(DefaultPluginRegistry.class);

  private static PluginRegistry instance = null;

  private Map<String, PluginMetaData> plugins;

  private DefaultPluginRegistry() {
    plugins = new HashMap<String, PluginMetaData>();
  }

  public static PluginRegistry create() {
    if (instance == null) {
      instance = new DefaultPluginRegistry();
    }
    return instance;
  }

  public void registerPlugin(String pluginName, String jarFileLocation) {
    plugins.put(pluginName, this.readMetaData(jarFileLocation));
  }

  private PluginMetaData readMetaData(String jarFileLocation) {
    //TODO: implement to open jar and read there metadata.json file and parse it
    //JarFile jar = JarScanner.openJar(jarFileLocation)
    //String pluginJson = jar.getPlugin.JSON
    //return JSONUtil.readJson(pluginJSON);
    return new PluginMetaData();
  }

  public boolean unregisterPlugin(String pluginName) {
    Assert.notEmpty(plugins, "There are no registered plugins.");
    return plugins.remove(pluginName, plugins.remove(pluginName));
  }


  public PluginMetaData getPlugin(String pluginName) {
    return plugins.get(pluginName);
  }


}
