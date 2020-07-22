package com.my.project.disconf.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.project.disconf.config.RedisConfig;

@Service
public class RedisService implements InitializingBean {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RedisConfig redisConfig;

	@Override
	public void afterPropertiesSet() throws Exception {
		
		logger.info("Redis host:{}  port:{}", redisConfig.getHost(), redisConfig.getPort());
		
	}
	
	public void logRedisConfig() {
		logger.info("Redis Config：");
		logger.info("Redis host:{}  port:{}", redisConfig.getHost(), redisConfig.getPort());
	}

    public void reload() throws Exception {
        logger.info("Redis Reload：");
        logger.info("Redis host:{}  port:{}", redisConfig.getHost(), redisConfig.getPort());
    }

}
