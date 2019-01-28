
package com.ivanllamas;

import java.io.File;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*Main Class for our Spring App. This small basic application is designed to show the basic uses of Spring framework,
this is an extension from our previous IoC Coach app, and implements dependency injection 
using the ClassPathXmlApplicationContext method, we can read a configuration from our coach bean 
in "applicationContext.xml" file, (beans are java objects), from there we create an object called myCoach
that takes the form of our bean in our file (we can configure it in the xml file), and outputs the method
depending on the configured coach(instead of hard coding each coach). also added a constructor-arg that references 
'myFortune' bean, and implements it into our dependency constructor in each coach class*/

public class HelloSpringApp {
    public static void main(String[] args){
        //load the configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      /*
       Check to see if the file exists
       File file = new File("src/main/java/applicationContext.xml");
       System.out.println(file.exists());
        
        */
      
        //retrieve bean from spring container, now has a dependency, we get the bean with the dependency
        Coach theCoach = context.getBean("myCoach", Coach.class);
        //call methods on the bean
       System.out.println(theCoach.getDailyWorkout());
       /*Calling the NEW fortune service (our dependency)*/
       System.out.println(theCoach.getDailyFortune());
        //close the context
        
        context.close();
        
        /*Note: PUT THE FILE IN THE RESOURCES FOLDER, OR ELSE YOU'LL GET A FILE NOT FOUND ERROR*/
    }
}
