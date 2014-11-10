package com.github.lobedan.spring.boot.plugin.core;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;

/**
 * Created by svenklemmer on 10.11.14.
 * <p/>
 * registers a {@link com.github.lobedan.spring.boot.plugin.core.PluginRegistry} which
 * stores all available plugins and is accessable by other beans
 */
public class PluginImportSelector implements DeferredImportSelector, BeanClassLoaderAware, ResourceLoaderAware {

  private static final Log LOGGER = LogFactory.getLog(PluginImportSelector.class);

  private ClassLoader beanClassLoader;

  private ResourceLoader resourceLoader;


  @Override
  public String[] selectImports(AnnotationMetadata metadata) {
      AnnotationAttributes attributes = AnnotationAttributes
          .fromMap(metadata.getAnnotationAttributes(EnablePlugin.class.getName(), true));

      Assert.notNull(attributes, "No enableplugin attributes found. Is "
                                 + metadata.getClassName()
                                 + " annotated with @EnablePlugin?");

      // Find all possible auto configuration classes, filtering duplicates
      List<String> factories = new ArrayList<String>(new LinkedHashSet<String>(
          SpringFactoriesLoader.loadFactoryNames(EnablePlugin.class, this.beanClassLoader)));

      LOGGER.debug("found " + factories.size() + " classes with @EnablePlugin");
    LOGGER.debug("classes " + factories);

      return factories.toArray(new String[factories.size()]);
  }

  @Override
  public void setResourceLoader(ResourceLoader aResourceLoader) {
    this.resourceLoader = aResourceLoader;
  }

  @Override
  public void setBeanClassLoader(ClassLoader aClassLoader) {
    this.beanClassLoader = aClassLoader;
  }
}
