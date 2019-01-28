
package com.ivanllamas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*       Demo used to demonstrate the different scopes for beans in our 
        "beanscope-applicationContext.xml" file (Using singleton & prototype)
*/
public class beanScopeDemo {
    public static void main(String[] args){
        //load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
        
        //retrieve bean from the spring container
        
        Coach theCoach = context.getBean("myCoach", Coach.class);
        
        Coach alphaCoach = context.getBean("myCoach", Coach.class);
        
        //check to see if they are the same beans
        boolean result = (theCoach == alphaCoach);
        
        System.out.println("\n are these the same object? : "+ result);
        
        System.out.println("\n Memory location for theCoach: " + theCoach);
        
        System.out.println("\n Memory location for alphaCoach: " + alphaCoach + "\n");
        
        //close the context
        context.close();
        /*Output using singleton scope
         are these the same object? : true

         Memory location for theCoach: com.ivanllamas.TrackCoach@5c072e3f

         Memory location for alphaCoach: com.ivanllamas.TrackCoach@5c072e3f
         =========================================================================
         Output using prototype scope
         are these the same object? : false

         Memory location for theCoach: com.ivanllamas.TrackCoach@710726a3

         Memory location for alphaCoach: com.ivanllamas.TrackCoach@646007f4
        
        */

        
    }
}
