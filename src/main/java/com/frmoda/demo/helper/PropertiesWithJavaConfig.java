package com.frmoda.demo.helper;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({
        @PropertySource("classpath:application.properties")
})
public class PropertiesWithJavaConfig {
}
