package com.ivanllamas;

import org.springframework.stereotype.Component;

/*Add component(a bean) to our spring container*/
@Component
public class RESTFortuneService implements FortuneService{

    @Override
    public String getFortune() {
     return null;
    }
    
}
