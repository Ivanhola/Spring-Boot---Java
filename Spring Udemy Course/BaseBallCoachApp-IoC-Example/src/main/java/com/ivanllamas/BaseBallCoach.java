
package com.ivanllamas;


public class BaseBallCoach implements Coach {
    /*Method returning a string on our daily workout, calling the method from our interface*/

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting Practice"; 
    }


}
