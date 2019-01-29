package com.ivanllamas;

import org.springframework.stereotype.Component;

/*This creates a bean in the spring container with the default bean id(tennisCoach)*/

//-removed ("thatCoolCoach")
@Component
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your swings!";
    }
    
}
