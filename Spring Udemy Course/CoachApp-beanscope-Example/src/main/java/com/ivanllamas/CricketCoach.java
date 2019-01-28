
package com.ivanllamas;




public class CricketCoach implements Coach {
    
    //add new fields for our values
    private String emailAddress;
    private String teamName;
    
    
    //create depedency variable/object
    private FortuneService fortuneService;
    
    //create a default constructor
    public CricketCoach(){
        System.out.println("Object was created with default constructor");
    }

   
                /*Interface Required Methods*/
    
    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling for 15 minutes"; 
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();  
    }
    
    
    //Step 1. Create Setter method for injection
    public void setFortuneService(FortuneService fortuneService) {
       
        System.out.println("The setter method in CricketCoach was used! - setFortuneService");
        this.fortuneService = fortuneService;
    }
    
                /*Setters*/
    
    
    public void setEmailAddress(String emailAddress) {
        System.out.println("The setter method in CricketCoach was used! - setEmailAddress");

        this.emailAddress = emailAddress;
    }

    public void setTeamName(String teamName) {
        System.out.println("The setter method in CricketCoach was used! - setTeamName");

        this.teamName = teamName;
    }
    
                /*Getters*/
    
    
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeamName() {
        return teamName;
    }
    
}
