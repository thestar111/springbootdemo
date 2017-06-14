package com.zping.boot;

import com.zping.config.JerseyConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ("com.zping")
public class SpringBootDemoApplication
{
	private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoApplication.class);

	@Bean
	public ServletRegistrationBean registResource ()
	{
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean (new ServletContainer (),
				"/rest/*");
		servletRegistrationBean
				.addInitParameter (ServletProperties.JAXRS_APPLICATION_CLASS, JerseyConfig.class.getName ());
		return servletRegistrationBean;
	}

	public static void main (String[] args)
	{
		SpringApplication.run (SpringBootDemoApplication.class, args);
	}
}
