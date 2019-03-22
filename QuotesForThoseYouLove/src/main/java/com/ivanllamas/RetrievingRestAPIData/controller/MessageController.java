
package com.ivanllamas.RetrievingRestAPIData.controller;

import com.ivanllamas.RetrievingRestAPIData.ApiEntity.MessageFromApi;
import com.ivanllamas.RetrievingRestAPIData.ApiEntity.MessageURL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MessageController {

    @GetMapping("/")
    public String mainPage(Model model){
        
         //Rest Template used to turn the JSON passed in from the API, into an object
                RestTemplate restTemplate = new RestTemplate();
                
                
                
                
                //http header required to see what user-agent browser you're working with
                 HttpHeaders headers = new HttpHeaders();
                         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
                         headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
                         HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
                
                                  //this can return the JSON list, and turn it into objects we can read from our list of Quotes.
                                 ResponseEntity<List<MessageURL>> response = restTemplate.exchange(
                                                                                                    "http://www.foaas.com/operations",
                                    HttpMethod.GET,
                                    entity,
                                    new ParameterizedTypeReference<List<MessageURL>>(){});
        
                        //get a list of MessageURL objects from the api /operations, it will only read the 'url' values from our entity         
                        List<MessageURL> quotes = response.getBody();
                
                        //random number from 1-list SIZE
                        int random = new Random().nextInt(quotes.size());
                        
                        //getting an object from the list, and then getting the string value using Getter and setting it to this variable
                        String url = quotes.get(random).getUrl();
                        //the url has :from values in it, replace it.
                        String newURL = url.replaceAll(":from", "your fucking mother");
                
                
                
                         /*Getting a message from the API*/
                ResponseEntity<MessageFromApi> rsp = restTemplate.exchange("https://www.foaas.com/" + newURL,  HttpMethod.GET,
                        entity,
                        new ParameterizedTypeReference<MessageFromApi>(){});
                
                            //Object that contains 'message' and 'subtitle' to interact with the API
                            MessageFromApi msg = rsp.getBody();               
                            System.out.println(msg.toString());
                            
                            model.addAttribute("message", msg);
                
                
                
       
               
                //System.out.print(quotes.get(random).toString());
        
        
        
        return "main-page";
    }
    
}
