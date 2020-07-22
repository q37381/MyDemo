package com.my.project.disconf;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.my.project.disconf.config.XmlMyServerConfig;
import com.my.project.disconf.service.BaoBaoService;
import com.my.project.disconf.service.GetAllPropService;
import com.my.project.disconf.service.RedisService;
import com.my.project.disconf.service.UpdateAnyService;

public class Starter {

    static Logger logger = LoggerFactory.getLogger(Starter.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/application.xml");
        app.start();
        RedisService bean = app.getBean(RedisService.class);

        bean.logRedisConfig();
        
        XmlMyServerConfig xml = app.getBean(XmlMyServerConfig.class);

        for (int i = 0; i < 1; i++) {
            logger.info("XmlUnReload: {}", xml.getHost());
            //Thread.sleep(5000);
        }
        

        BaoBaoService b = app.getBean(BaoBaoService.class);

        for (int i = 0; i < 1; i++) {
            b.pay();
          //  Thread.sleep(5000);
        }
        
        System.out.println(b.host);
        

        Map<String, Object> byFile = GetAllPropService.getByFile("redis.properties");
        
        byFile.forEach((k,v)->{
            logger.info("ByFile : {} : {}",k,v);
        });
        
        Object byFileItem = GetAllPropService.getByFileItem("redis.properties", "host");
        
        logger.info("ByFileItem: {}",byFileItem);
        
        Object byItem = GetAllPropService.getByItem("discount");
        
        logger.info("byItem: {}",byItem);
        
        System.in.read();

        app.close();
    }

}
