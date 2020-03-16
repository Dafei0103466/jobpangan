package com.pangan.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@ComponentScan(basePackages = {"com.dafei.*"})
@PropertySource(value = "config.properties")
public class Config {
}
