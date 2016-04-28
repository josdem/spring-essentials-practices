package com.makingdevs.practica4;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.makingdevs.services.UserService;

public class UseSpringAsLibraryTests {

  @Test
  public void useSpringWithBeanFactory() {
    DefaultListableBeanFactory xbf = new DefaultListableBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(xbf);
    reader.loadBeanDefinitions(new ClassPathResource("/com/makingdevs/practica4/ApplicationContext.xml", getClass()));
    UserService userService = (UserService)xbf.getBean("userService");
    assertNotNull(userService);
  }
  
  @Test
  public void useSpringWithAppCtx() {
    ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/makingdevs/practica4/ApplicationContext.xml");
    UserService userService = (UserService)appCtx.getBean("userService");
    assertNotNull(userService);
  }
  
  @Test
  public void useSpringWithAppCtxByType() {
    ApplicationContext appCtx = new ClassPathXmlApplicationContext("com/makingdevs/practica4/ApplicationContext.xml");
    UserService userService = appCtx.getBean(UserService.class);
    assertNotNull(userService);
  }

}