package com.ivanllamas;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*This class will implement the Field Injection method, by injecting dependencies via the field method*/

/*In this class we will inject values onto our email and name variables using annotation and from a properties file
 in order for this to work, we must add <context:property-placeholder location=”classpath:sport.properties” />
 to our xml file where this bean is stored
*/
@Component

public class TennisCoach implements Coach {
    
   /*When running without @Qualifier, there are too many matching beans that implement FortuneService, and are 
    matches for this injection*/
    @Autowired
    @Qualifier("randomFortuneService") //calling our randomFortuneService component since there are too many others(choose by being specific)
    private FortuneService fortuneService;
    
  
    
    
    public TennisCoach(){
        System.out.println("Default Constructor for TennisCoach");
    }
    
    
    /*Define Lifecycle methods: When starting up our bean life, it will run an init method, and when the bean 
    is at the end of its cycle (program closing) it will run the destroy method */
    
    
    //define our init method
    @PostConstruct
    public void initStartup(){
    System.out.println("We are inside the initStartup() method! - TennisCoach");
    
    }
    //define our destroy method
    @PreDestroy
    public void cleanUpStuff(){
    System.out.println("We are inside the cleanUpStuff() method! - TennisCoach");
    }
    
 

    @Override
    public String getDailyWorkout() {
        return "Practice your swings!";
    }

    @Override
    public String getDailyFortune() {
       return fortuneService.getFortune();
    }

    
    
    
}

/*   See: SD-ComponentSetterInjection project for information/example of setter injection
    @Autowired
    public void setFortuneService(FortuneService fortuneService){
        System.out.println("inside the setFortuneService() method in class: TennisCoach");
        this.fortuneService = fortuneService;
    }

*/


/* See: SD-ComponentConstructorInjection project for more information/example of constructor injection
    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }
*/

