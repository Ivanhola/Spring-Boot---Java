
package com.ivanllamas;

import org.springframework.beans.factory.annotation.Value;

/*This will be our bean using Java code, no special annotations or anything like that, we will need a FortuneService
variable, and a Constructor for injection that takes in a FortuneService implemented object*/
public class SwimCoach implements Coach {
    
    @Value("${foo.email}")
    private String email;
    
    @Value("${foo.name}")
    private String name;
    
    
    /*We're gonna implement a fortune service dependency*/
    private FortuneService fortuneService;
    
    /*Constructor to inject our FortuneService dependency*/
    public SwimCoach(FortuneService theFortuneService){
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100 meters as a warm up";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

                                    /*Getters*/
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

}
