
package com.ivanllamas;


public class LeagueOfLegendsCoach implements Coach {
    //private field for our dependency
    private FortuneService fortuneService;
    
    //constructor that takes in a dependency
    public LeagueOfLegendsCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    
    /*Method required by our Coach Interface*/
    @Override
    public String getDailyWorkout() {
        return "You will get to diamond today!!";
    
    }
    /*Method required by our Coach Interface*/
    @Override
    public String getDailyFortune() {
        return "You teammates will be: " + fortuneService.getFortune();  
    }
    
}
