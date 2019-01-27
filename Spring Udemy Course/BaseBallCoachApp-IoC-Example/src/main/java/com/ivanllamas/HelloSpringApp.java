
package com.ivanllamas;

import java.io.File;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*Main Class for our Spring App. This small basic application is designed to show the basic uses of Spring framework,
We have a coach interface that contains a getDailyWorkout() method. 
using the ClassPathXmlApplicationContext method, we can read a configuration from our coach bean 
in "applicationContext.xml" file, (beans are java objects), from there we create an object called theCoach
that takes the form of our bean in our file (we can configure it in the xml file), and outputs the method
depending on the configured coach(instead of hard coding each coach). */
public class HelloSpringApp {
    public static void main(String[] args){
        //load the configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
      /*
       Check to see if the file exists
       File file = new File("src/main/java/applicationContext.xml");
       System.out.println(file.exists());
        
        */
      
        //retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);
        //call methods on the bean
       System.out.println(theCoach.getDailyWorkout());
        //close the context
        
        context.close();
        
        /*Note: PUT THE FILE IN THE RESOURCES FOLDER, OR ELSE YOU'LL GET A FILE NOT FOUND ERROR*/
    }
}
