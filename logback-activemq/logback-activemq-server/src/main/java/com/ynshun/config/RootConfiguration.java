package com.ynshun.config;

import javax.annotation.PostConstruct;

import org.java_websocket.WebSocketImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.ynshun.config.websocket.WsServer;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(value = "com.ynshun", excludeFilters = { @Filter(Controller.class),
		@Filter(type = FilterType.ASSIGNABLE_TYPE, value = { RootConfiguration.class }) })
public class RootConfiguration extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	@PostConstruct
	public void init() {
		WebSocketImpl.DEBUG = false;
		int port = 8887;
		WsServer s = new WsServer(port);
		s.start();
	}

}