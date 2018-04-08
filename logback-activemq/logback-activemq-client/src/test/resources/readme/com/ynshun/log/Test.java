package com.ynshun.log;


import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	private static final Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 10; ) {
			try {
				if (random.nextInt(20) % 5 == 0) {
					logger.info(UUID.randomUUID().toString());
					i++;
				}
				if (random.nextInt(20) % 5 == 0) {
					logger.debug(UUID.randomUUID().toString());
					i++;
				}
				if (random.nextInt(20) % 5 == 0) {
					logger.warn(UUID.randomUUID().toString());
					i++;
				}
				if (random.nextInt(20) % 5 == 0) {
					logger.error(UUID.randomUUID().toString());
					i++;
				}
				Thread.sleep(100);
			} catch (Exception e) {
				logger.info("你好{}", e.getMessage(), e);
			}
		}
	}
}