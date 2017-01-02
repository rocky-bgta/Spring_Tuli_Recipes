package com.salahin.spring.recipes.test.spring.annotations;


import com.salahin.spring.recipes.beanLifeCycle.BeanLifeCycleConfiguration;
import com.salahin.spring.recipes.beanLifeCycle.CompleteLivingBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by iuliana.cosmina on 1/17/15.
 * Description: Tests class used to display the lifecycle of a bean
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanLifeCycleConfiguration.class)
public class BeanLifecycleTest implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Test
    public void showLifcycle() {
        CompleteLivingBean bean = applicationContext.getBean(CompleteLivingBean.class);
        assertNotNull(bean);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
