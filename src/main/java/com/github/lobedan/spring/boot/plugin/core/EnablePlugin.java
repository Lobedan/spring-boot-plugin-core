package com.github.lobedan.spring.boot.plugin.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.github.lobedan.spring.boot.plugin.core.configuration.PluginAutoConfiguration;
import com.github.lobedan.spring.boot.plugin.core.configuration.PluginProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * Enable import of plugins, which are placed in a folder defined in your applicaion.properties
 *
 * Plugins can be placed as a jar and wil be loaded in your classpath ready to use by
 * spring boot
 *
 * Bootstraps {@link com.github.lobedan.spring.boot.plugin.core.PluginImportSelector}
 *
 * @author Sven Klemmer
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableConfigurationProperties(PluginProperties.class)
@Import(value = { PluginAutoConfiguration.class, PluginAutoRegister.class})
public @interface EnablePlugin {

}
