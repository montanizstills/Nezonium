package com.vertexinc.returns.test.cloudui.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    String className;
    Logger logger = LoggerFactory.getLogger(className);

    public void start(Object input){
//        this.logger.info(input);
        logger.atDebug().addKeyValue("",input);
    }


}
