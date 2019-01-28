
package com.ivanllamas;

import java.util.Random;

            /*Our FortuneService class that implements our FortuneService interface*/
public class HappyFortuneService implements FortuneService {

    /*FortuneService Interface-required-method*/
    @Override
    public String getFortune() {
        /*Create an array of Strings (3 elements)*/
         String[] fortunes = new String[3];
         fortunes[0] = "Today will be your lucky day!";
         fortunes[1] = "This is your moment!";
         fortunes[2] = "This will be your luckiest day ever!";
         /*pick a random number from the length of the array 0-2*/
         int random = new Random().nextInt(fortunes.length);
        /*choose a fortune string from a random number*/
        return fortunes[random]; 
    }
    
}
