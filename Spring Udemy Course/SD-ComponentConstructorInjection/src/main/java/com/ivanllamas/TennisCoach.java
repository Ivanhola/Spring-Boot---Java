package com.ivanllamas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*This creates a bean in the spring container with the default bean id(tennisCoach)*/

//-removed ("thatCoolCoach")
@Component
public class TennisCoach implements Coach {
    
    private FortuneService fortuneService;
    
    /*Spring will scan for a component that implements the FortuneService interface(HappyFortuneService meets this requirement)
     and spring will then inject that HappyFortuneService into the constructor*/
    
    @Autowired
    public TennisCoach(FortuneService theFortuneService){
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your swings!";
    }

    @Override
    public String getDailyFortune() {
       return fortuneService.getFortune();
    }
    
}

/*Note: 
When adding a @Component annotation to a class, spring will create a bean from that class and add it to whatever
xml file has component scanning enabled. (In our case applicationContext.xml)
When it scans @Component, it does the following for this class.

            <bean id="tennisCoach"
                     class="com.ivanllamas.TennisCoach">
OR
//our Component annotation is empty, uses default naming scheme
            TennisCoach tennisCoach = new TennisCoach();

Since we added the Autowired annotation
it will now do: 

                <bean id="tennisCoach"
                     class="com.ivanllamas.TennisCoach">
                <constructor-arg ref=""/>

AutoWired will check other components (beans) and see which one matches or implements the same class in the
constructor(FortuneService)

Since we created another component in the HappyFortuneService class, it implements the FortuneService interface
and injects it into the constructor-arg field (or it injects it into the constructor)

                <bean id="tennisCoach"
                       class="com.ivanllamas.TennisCoach">
                <constructor-arg ref="happyFortuneService"/> //THIS IS THE ID OF THE OTHER COMPONENT WE CREATED(HappyFortuneService)

Codewise:

TennisCoach tennisCoach = new TennisCoach(happyFortuneService);
----------------------------------------------------------------
Beanclass   beanID     constructor-arg   ref="beanID";


*/