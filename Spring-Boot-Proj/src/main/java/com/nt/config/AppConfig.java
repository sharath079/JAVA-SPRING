package com.nt.config;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "{com.nt}")
public class AppConfig {
    @Bean(name = "cal")
	public Calendar createCalendar() {
		return Calendar.getInstance();
	}
}
