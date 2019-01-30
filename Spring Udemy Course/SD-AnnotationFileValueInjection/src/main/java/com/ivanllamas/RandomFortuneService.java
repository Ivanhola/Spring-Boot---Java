package com.ivanllamas;

import java.util.Random;
import org.springframework.stereotype.Component;

/*Create a component (bean) for RandomeFortuneService*/
@Component
public class RandomFortuneService implements FortuneService {

    //create an array of Strings
    private String[] Fortunes;
    private Random myRandom;
    
    @Override
    public String getFortune() {
    
    //initialize the array
    Fortunes = new String[]{"Look both directions when Crossing the road!",
    "Keep working hard! You'll get there!", 
    "The journey is the reward!"};
    //initialize the random
    myRandom = new Random();
    
    //pick a random number from 0 to the length of the array
    int index = myRandom.nextInt(Fortunes.length);
    //pick a String value from the random number
    String theFortune = Fortunes[index];
    
        return theFortune;
    }
    
}
