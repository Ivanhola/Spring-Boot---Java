
package com.ivanllamas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*This Program demonstrates how to Inject Values into your variables from a properties file.
See TennisCoach Class for example

*/



public class SpringDemoAnnotation {
    
        
        /*Add xml file with component scanning to allow @Component to create beans and use */
    
    public static void main(String[] args) {
       /*Read spring config file*/
       
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       /*Get the bean from the spring container*/
       
       //will see an error if you don't use the default bean ID
       TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);
       
       /*Call a method from the bean*/
       
       System.out.println(theCoach.getDailyWorkout());
       
       
       System.out.println(theCoach.getDailyFortune());
       
       System.out.println(theCoach.getEmail());
       
       System.out.println(theCoach.getName());
       
       

       
       /*close the context*/
       context.close();
    }
    
}
