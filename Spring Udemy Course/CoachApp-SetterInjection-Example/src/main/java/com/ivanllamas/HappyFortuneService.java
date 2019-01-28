
package com.ivanllamas;

            /*Our FortuneService class that implements our FortuneService interface*/
public class HappyFortuneService implements FortuneService {

    /*FortuneService Interface-required-method*/
    @Override
    public String getFortune() {
        
        return "Today will be your lucky day!"; 
    }
    
}
