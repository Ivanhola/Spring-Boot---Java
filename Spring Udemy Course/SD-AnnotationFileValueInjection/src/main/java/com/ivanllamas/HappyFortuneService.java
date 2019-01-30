package com.ivanllamas;

import org.springframework.stereotype.Component;

/*This class will implement the FortuneService Interface*/

/*Spring will scan this class, and register this component*/
@Component
public class HappyFortuneService implements FortuneService{
    
    public HappyFortuneService(){
        System.out.println("inside the HappyFortuneService default Constructor!");
    }

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }
    
    
    
}
