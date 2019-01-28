
package com.ivanllamas;

public interface Coach {
    /*Different coaches can implement this method, depending on the type of coach they are*/
 public String getDailyWorkout();
 /*We will want our interface to implement dailyFortunes*/
 public String getDailyFortune();
}
