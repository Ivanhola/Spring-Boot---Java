
package com.ivanllamas;


public class CricketCoach implements Coach {
    //create depedency variable/object
    private FortuneService fortuneService;
    
    //create a default constructor
    public CricketCoach(){
        System.out.println("Object was created with default constructor");
    }

    //Step 1. Create Setter method for injection
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("The setter method in CricketCoach was used! - setFortuneService");
        this.fortuneService = fortuneService;
    }
    
    
    
    
    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling for 15 minutes"; }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();  
    }
    
}
