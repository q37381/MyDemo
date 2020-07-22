package com.my.project.disconf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;
import com.my.project.disconf.service.RedisService;

@Configuration
@DisconfFile(filename = "redis.properties")
@DisconfUpdateService(classes = RedisConfig.class, itemKeys = { "discount" } /* 该项改变 也刷新 */)
public class RedisConfig implements IDisconfUpdate {

    private String host;

    private int port;

    @Autowired
    RedisService redisService;

    @DisconfFileItem(name = "redis.host", associateField = "host")
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @DisconfFileItem(name = "redis.port", associateField = "port")
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void reload() throws Exception {
        redisService.reload();
    }

}
