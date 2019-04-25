
package com.ivanllamas.YoutubeVideoViewer.controller;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.ivanllamas.YoutubeVideoViewer.entity.ItemToSearch;
import com.ivanllamas.YoutubeVideoViewer.service.YoutubeService;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final YoutubeService youtubeService;

    @Autowired
    public IndexController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }
    
    @RequestMapping("/")
    public String home(Model model){
        
        ItemToSearch search = new ItemToSearch();
        
        model.addAttribute("search", search);
        return "home";
    }
    
    @RequestMapping("/search")
    public String searchProcessed(@ModelAttribute("search")ItemToSearch searched, Model model)
    throws GeneralSecurityException, IOException, GoogleJsonResponseException{
        
        model.addAttribute("list",youtubeService.searchVideos(searched.getSearchItem()));
        return "videoSearched";
    }
    
    @RequestMapping("/trending")
    public String trendingVideos(Model model)
    throws GeneralSecurityException, IOException, GoogleJsonResponseException{
        
        model.addAttribute("list",youtubeService.popularVideos());
        return "popularVideos";
    }
    
    
}
