package com.demo.spring_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
   public static void main(String[] args) {
//      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	   ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);

      Student student = (Student) context.getBean(Student.class);
      student.getName();
      student.getAge();

//      student.printThrowException();
   }
}
