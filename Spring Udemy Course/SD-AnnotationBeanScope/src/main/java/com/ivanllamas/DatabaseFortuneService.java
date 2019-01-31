package com.ivanllamas;

import org.springframework.stereotype.Component;

/*Add component (bean) to our Spring container*/
@Component
public class DatabaseFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return null;
    }
    
}
