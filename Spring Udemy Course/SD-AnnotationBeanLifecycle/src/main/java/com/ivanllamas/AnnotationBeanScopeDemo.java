package com.ivanllamas;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AnnotationBeanScopeDemo {

   
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //retrieve bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
        
        //check to see if they are the same object
        boolean test = (theCoach == alphaCoach);
        
        System.out.println("Are these the same object? : " + test);
        
        System.out.println("\n memory location for theCoach: " + theCoach);
        
        System.out.println("\n memory location for alphaCoach: " + alphaCoach);

        //close context
        context.close();
    }
    
}

/* Output for default scope ("singleton")

Are these the same object? : true

memory location for theCoach: com.ivanllamas.TennisCoach@3901d134

memory location for alphaCoach: com.ivanllamas.TennisCoach@3901d134

*/

/**********************************************************************************/

/*Output for prototype scope ("prototype")

Are these the same object? : false

memory location for theCoach: com.ivanllamas.TennisCoach@d706f19

memory location for alphaCoach: com.ivanllamas.TennisCoach@30b7c004

*/
