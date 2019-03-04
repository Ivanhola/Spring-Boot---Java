package com.ivanllamas.RetrievingRestAPIData;

import com.ivanllamas.RetrievingRestAPIData.ApiEntity.Quote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RetrievingRestApiDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetrievingRestApiDataApplication.class, args);
                
                //Rest Template used to turn the JSON passed in from the API, into an object
                RestTemplate restTemplate = new RestTemplate();
                
                //this takes a URL from an API, and turns the data from the JSON into an object of type Quote class
                Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
                
                System.out.print(quote.toString());
                
	}

}
