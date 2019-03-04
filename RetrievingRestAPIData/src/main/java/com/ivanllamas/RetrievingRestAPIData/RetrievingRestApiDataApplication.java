package com.ivanllamas.RetrievingRestAPIData;

import com.ivanllamas.RetrievingRestAPIData.ApiEntity.Quote;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RetrievingRestApiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetrievingRestApiDataApplication.class, args);
                
                //Rest Template used to turn the JSON passed in from the API, into an object
                RestTemplate restTemplate = new RestTemplate();
                
                //this takes a URL from an API, and turns the data from the JSON into an object of type Quote class
               
                Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/3", Quote.class);
                
                
                
                //this can return the JSON list, and turn it into objects we can read from our list of Quotes.
        ResponseEntity<List<Quote>> response = restTemplate.exchange(
             "http://gturnquist-quoters.cfapps.io/api",
                     HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Quote>>(){});
                        List<Quote> quotes = response.getBody();
                
                System.out.print(quotes.get(0).toString());
                
	}

}
