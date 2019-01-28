
package com.ivanllamas;

/*This is going to be our Fortune Service Interface, a dependency that our Coach objects will depend on 
to provide FortuneServices, any class that implements this interface will require the getFortune() method*/
public interface FortuneService {
    public String getFortune();
}
