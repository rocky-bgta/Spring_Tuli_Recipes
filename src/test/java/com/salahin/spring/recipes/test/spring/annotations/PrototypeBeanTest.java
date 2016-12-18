package com.salahin.spring.recipes.test.spring.annotations;


import com.salahin.spring.recipes.beanLifeCycle.PrototypeBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by iuliana.cosmina on 1/17/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PrototypeBean.class)
public class PrototypeBeanTest implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Test
    public void testPrototype() {

        PrototypeBean pb1 = (PrototypeBean)applicationContext.getBean("prototypeBean");
        assertNotNull(pb1);
        PrototypeBean pb2 = applicationContext.getBean(PrototypeBean.class);
        assertNotNull(pb2);
        assertNotEquals(pb1,pb2);
        assertEquals(PrototypeBean.instanceCounter(), 2);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
