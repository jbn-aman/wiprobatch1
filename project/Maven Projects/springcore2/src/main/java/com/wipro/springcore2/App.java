package com.wipro.springcore2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.springcore2.bean.HelloBean;

import com.wipro.springcore2.config.MyAppConfig;

public class App {
    public static void main( String[] args )
    {
//       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
//       HelloBean helloBean = (HelloBean) context.getBean("hBean");
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class);
    	HelloBean helloBean = context.getBean(HelloBean.class);
    	
    	helloBean.sayHello();
    	context.close();
    }
}