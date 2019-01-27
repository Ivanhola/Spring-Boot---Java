
package com.ivanllamas;


public class MyApp {
 public static void main(String[] args){
     /*Creating the object*/
     Coach baseBallCoach = new BaseBallCoach(); // Coach interface object, with BaseBallCoach Object implementing Coach methods
     Coach coach = new TrackCoach();

     /*Calling a method in our object, can work with any coach that has the getDailyWorkout implementation*/
     System.out.println(coach.getDailyWorkout());
     
 }
 
 /*The problem with this program, is that it's not configurable. We can handle different types of coaches,
 But the coach implementation should be configurable. It's hard coded in the program right now, ideally we could
 change a config file, and change the type of coaches.(We Will use Spring to address this issue)
 */
 
 
 /*Added a file applicationContext.xml
 configuring our bean(objects)
 */
}
