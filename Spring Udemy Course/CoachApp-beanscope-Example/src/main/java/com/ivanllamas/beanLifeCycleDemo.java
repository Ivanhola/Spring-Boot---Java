
package com.ivanllamas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*       Demo used to demonstrate the different lifecycles for beans in our 
        "beanLifeCycle-applicationContext.xml" file (Using singleton & prototype)
*/
public class beanLifeCycleDemo {
    public static void main(String[] args){
        //load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
        
        //retrieve bean from the spring container
        
        Coach theCoach = context.getBean("myCoach", Coach.class);
        
        System.out.println(theCoach.getDailyWorkout());
        
        //close the context
       context.close();

        
    }
}
