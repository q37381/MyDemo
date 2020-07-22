package com.my.project.disconf.service;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.update.IDisconfUpdatePipeline;

@Service
public class UpdateAnyService implements IDisconfUpdatePipeline {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void reloadDisconfFile(String key, String filePath) throws Exception {
        logger.info("{}:{}", key, filePath);

        Properties properties = new Properties();
        properties.load(new FileInputStream(filePath));
        Set<Object> keySet = properties.keySet();
        for (Object object : keySet) {
            logger.info("Property: {} : {}" ,object,properties.getProperty((String)object));
        }

    }

    @Override
    public void reloadDisconfItem(String key, Object content) throws Exception {
        logger.info("{}:{}", key, content);
    }

}
