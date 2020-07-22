package com.my.project.disconf.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.my.project.disconf.config.Coefficients;

@Service
public class BaoBaoService {

    @Value("${myserver.host}")
    public String host;
    
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Coefficients coefficients;

    public void pay() {
        logger.info("discount: {}", coefficients.getDiscount());
    }
}
