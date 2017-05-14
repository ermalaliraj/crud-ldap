package com.ea.crud.service;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Used for simple tests (non-web)
 *
 */
public class AbstractSpringTest extends TestCase {

    protected ClassPathXmlApplicationContext applicationContext;

    protected String[] getApplicationContextPath() {
        return new String[] { "classpath:pring-context.xml",
			        		"classpath:persistence-context.xml"
			        		};
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        applicationContext = new ClassPathXmlApplicationContext(getApplicationContextPath());
    }
}
