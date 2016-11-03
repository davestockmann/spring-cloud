package com.perficient.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignConfiguration {

	@Bean
	public Logger.Level feignLogger() {
		return Logger.Level.FULL;
	}

}
