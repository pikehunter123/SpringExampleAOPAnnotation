package com.tutorialspoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;

@Aspect
public class Logging {

   /** Following is the definition for a pointcut to select
    *  all the methods available. So advice will be called
    *  for all the methods.
    */
 
       @Pointcut("execution(* com.tutorialspoint.*.setAge(..))  && args(yourAge)")
   private void setPCA(int yourAge){}

   @Before("setPCA(yourAge)")
   public void beforeAdviceSet(JoinPoint joinPoint,int yourAge){
      System.out.println("hijacked : " + joinPoint.getSignature().getName());
      System.out.println("hijacked setting value: " + (int)(joinPoint.getArgs()[0]));
      System.out.println("AOP before setup age ..."+yourAge+ " Logthread:"+Thread.currentThread().hashCode());
   }
 
    
    @Pointcut("execution(* com.tutorialspoint.*.setName(..))  && args(yourString,..)")
   private void setPC(String yourString){}

   @Before("setPC(yourString)")
   public void beforeAdviceSet(String yourString){
      System.out.println("AOP before setup name ..."+yourString+ " Logthread:"+Thread.currentThread().hashCode());
   }
   
    @Pointcut("execution(* com.tutorialspoint.*.getAge(..))")
   private void selectAll(){}

   /** 
    * This is the method which I would like to execute
    * before a selected method execution.
    */
   @Before("selectAll()")
   public void beforeAdvice(){
      System.out.println("Going to setup student profile."+ " Logthread:"+Thread.currentThread().hashCode());
   }

   /** 
    * This is the method which I would like to execute
    * after a selected method execution.
    */
   @After("selectAll()")
   public void afterAdvice(){
      System.out.println("Student profile has been setup."+ " Logthread:"+Thread.currentThread().hashCode());
   }

   /** 
    * This is the method which I would like to execute
    * when any method returns.
    */
   @AfterReturning(pointcut = "selectAll()", returning="retVal")
   public void afterReturningAdvice(Object retVal){
       String ret=retVal==null?"null":retVal.toString();
      System.out.println("Returning:" + ret + " Logthread:"+Thread.currentThread().hashCode());
   }

   /**
    * This is the method which I would like to execute
    * if there is an exception raised by any method.
    */
   @AfterThrowing(pointcut = "selectAll()", throwing = "ex")
   public void AfterThrowingAdvice(IllegalArgumentException ex){
      System.out.println("There has been an exception: " + ex.toString()+ " Logthread:"+Thread.currentThread().hashCode());   
   }
   
}