
package com.ivanllamas.Joke.application.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes cnj;
    
    //initializes the ChuckNorrisQuotes when the constructor is called. 
    public JokeServiceImpl(){
        this.cnj = new ChuckNorrisQuotes();
    }
    
    @Override
    public String getJoke() {
            return cnj.getRandomQuote();   
    }

}
