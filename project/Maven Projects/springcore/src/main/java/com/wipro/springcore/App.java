package com.wipro.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ){
    	
    	
    	/*Square s = new Square();
    	s.setSide(4);
    	
    	triangle t = new triangle();
    	t.setBase(5);
    	t.setHeight(8);
    	
    	ShapeService service = new ShapeService();
    	service.setShape(t);*/
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
    	ShapeService service = (ShapeService) context.getBean("sService");
      
    	double area = service.findArea();
    	System.out.println(area);
    }
}
