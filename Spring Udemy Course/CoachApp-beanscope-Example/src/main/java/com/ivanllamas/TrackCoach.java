/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivanllamas;

/**
 *
 * @author beandog
 */
public class TrackCoach implements Coach {

    //Private field for our dependency
    private FortuneService fortuneService;
    
    public TrackCoach(){
    }
    //Dependency injecting Constructor
    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    
    

    @Override
    public String getDailyWorkout() {
        return "Run 5 Miles today"; }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }
    
    //add an init method 
    public void doMyStartupStuff(){
        System.out.println("TrackCoach: Inside doMyStartupStuff! ");
    }
    //add a destory method
    public void doMyCleanupStuff(){
        System.out.println("TrackCoach: Inside doMyCleanupStuff! ");
    }
    
}
