package com.ivanllamas;

import org.springframework.stereotype.Component;

/*This creates a bean in the spring container with the id of "thatCoolCoach" which we can retrieve at a later time*/
@Component("thatCoolCoach")
public class TennisCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice your swings!";
    }
    
}
