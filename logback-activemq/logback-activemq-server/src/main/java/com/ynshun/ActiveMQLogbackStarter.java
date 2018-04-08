package com.ynshun;

import org.springframework.boot.SpringApplication;

import com.ynshun.config.RootConfiguration;

/**
 * @description:
 *
 * @createdTime: 2017年11月30日 上午11:52:19
 * @createdUser: ynshun
 * @version: 1.0
 */
public class ActiveMQLogbackStarter {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RootConfiguration.class, args);
	}

}
