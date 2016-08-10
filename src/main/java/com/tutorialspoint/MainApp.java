package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      System.out.println("---------main--------start");
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("beans.xml");
      System.out.println("---------main--------context");
      
      Student student = (Student) context.getBean("student");
      System.out.println("---------main--------received bean");
      student.setAge(12);
      student.setName("Tralala");
      System.out.println("---------main--------age setted 12");
      student.getName();
      student.getAge();
      
      System.out.println("------------------------------------------------------------------------");
      
      //student=new Student();
      student.setAge(11);
      student.setName("bob");
      student.getName();
      student.getAge();
      
      //student.printThrowException();
   }
}