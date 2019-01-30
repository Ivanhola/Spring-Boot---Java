
package com.ivanllamas;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*This Program demonstrates how to Inject Dependencies with annotations @Component and @Autowiring.
  This program demonstrates the @Qualifier Annotation usage: What happens if there are multiple components
  when @Autowired is trying to inject a dependency and finds multiple matches when scanning Components?
  use @Qualifier("beanID")

*/



public class SpringDemoAnnotation {
    
        
        /*Add xml file with component scanning to allow @Component to create beans and use */
    
    public static void main(String[] args) {
       /*Read spring config file*/
       
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
       
       /*Get the bean from the spring container*/
       
       //will see an error if you don't use the default bean ID
       Coach theCoach = context.getBean("tennisCoach", Coach.class);
       
       /*Call a method from the bean*/
       
       System.out.println(theCoach.getDailyWorkout());
       
       
       System.out.println(theCoach.getDailyFortune());

       
       /*close the context*/
       context.close();
    }
    
}
