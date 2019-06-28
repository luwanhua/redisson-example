package com.story.example.redissonstart.config;

import java.io.IOException;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class RedissonConfig {

	@Bean(destroyMethod = "shutdown", name = "redissonClient")
	public RedissonClient redisson(@Value("classpath:/redisson-config.json") Resource configFile)
			throws IOException {
		Config config = Config.fromJSON(configFile.getInputStream());
		return Redisson.create(config);
	}

}
