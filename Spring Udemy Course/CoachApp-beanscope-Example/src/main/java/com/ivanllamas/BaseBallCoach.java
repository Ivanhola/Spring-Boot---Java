
package com.ivanllamas;


public class BaseBallCoach implements Coach {
    
    //define a private field for our dependency
    private FortuneService fortuneService;
    
    //define a constructor for dependency injection
    public BaseBallCoach(FortuneService theFortuneService){
        fortuneService = theFortuneService;
    }
    
    
    /*method required by our Coach Interface*/
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting Practice"; 
    }
    /*method required by our Coach Interface*/
    @Override
    public String getDailyFortune() {
        //use my fortuneService to get a fortune (making use of our dependency)
        return fortuneService.getFortune(); }


}
