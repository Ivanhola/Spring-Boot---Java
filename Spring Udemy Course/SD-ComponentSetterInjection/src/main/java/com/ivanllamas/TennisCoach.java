package com.ivanllamas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*This class will implement the  Setter Injection method, by injecting dependencies via setter method*/

/*This creates a bean in the spring container with the default bean id(tennisCoach)*/

//-removed ("thatCoolCoach")
@Component
public class TennisCoach implements Coach {
    
    private FortuneService fortuneService;
    
    public TennisCoach(){
        System.out.println("Default Constructor for TennisCoach");
    }
    
    
    /*Define a setter Method for FortuneService*/
    @Autowired
    public void setFortuneService(FortuneService fortuneService){
        System.out.println("inside the setFortuneService() method in class: TennisCoach");
        this.fortuneService = fortuneService;
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

/* See: SD-ComponentConstructorInjection project for more information/example of constructor injection
    @Autowired
    public TennisCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }
*/

