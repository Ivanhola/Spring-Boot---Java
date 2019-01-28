
package com.ivanllamas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*This main method is used to demo the Setter Injection that spring uses
when 'theCoach' is created, it calls the object information from our xml file, and gets the 
'myCricketCoach' object and its configurations in our bean (when this is called it will call a setter method to set
the fortuneService in a setter), once the object is created we can use the methods such as getDailyWorkout & getDailyFortune*/

/*Whats new in this program vs Setter Injection
    - Added new variables EmailAddress & TeamName
    - Added NEW setters in the CricketCoach class
    - Added Getters for our new variable injected values
    - Added new Configuration in our applicationContext.xml file to take in literal Values
    - System.out.println using out getters for email and team name
*/
public class SetterInjectionDemo {
    public static void main(String[] args){
        
        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //retrieve bean(object) from the spring container
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
        
        /* 'myCricketCoach' is the name of the bean id (object name)*/
        
        //call methods on the bean
        
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        
        //call our new method
        
        System.out.println(theCoach.getEmailAddress());
        System.out.println(theCoach.getTeamName());
        
        //close the spring context
        context.close();
    }
}
