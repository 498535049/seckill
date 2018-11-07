package com.spring.test.domain;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 重写Dozer的spring实现
 * @author <a href="mailto:qianxw@uubee.com">qianxw</a>
 * @version $Id$
 * @since 2.0
 */
 class DozerBeanMapperFactoryBean extends DozerBeanMapper {


    /**    */
    private final static Logger LOGGER = LoggerFactory
            .getLogger(DozerBeanMapperFactoryBean.class);


    /**
     * 初始化
     */
    public void init() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("init dozer config.");
        }
        super.getMappingProcessor();
    }


}
