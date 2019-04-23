
package com.ivanllamas.YoutubeVideoViewer.controller;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.ivanllamas.YoutubeVideoViewer.service.YoutubeService;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final YoutubeService youtubeService;

    @Autowired
    public IndexController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }
    
    @RequestMapping("/")
    public String home() throws GeneralSecurityException, IOException, GoogleJsonResponseException{
        youtubeService.searchVideos("Helloworld");
        
        return "home";
    }
    
    
}
