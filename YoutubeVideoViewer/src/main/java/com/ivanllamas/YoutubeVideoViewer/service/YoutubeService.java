
package com.ivanllamas.YoutubeVideoViewer.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.YouTube;

import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.ivanllamas.YoutubeVideoViewer.entity.YoutubeVideo;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class YoutubeService {
 // You need to set this value for your code to compile.
    // For example: ... DEVELOPER_KEY = "YOUR ACTUAL KEY";
    public static final String DEVELOPER_KEY = "AIzaSyD_JOjza3z3LGf24KbiXpPLkMiDkYTm27k123212312312321";
    public static final String VIDEO_URL = "https://www.youtube.com/watch?v=";
    private static final String APPLICATION_NAME = "API code samples";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    /**
     * Build and return an authorized API client service.
     *
     * @return an authorized API client service
     * @throws GeneralSecurityException, IOException
     */
    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
            .setApplicationName(APPLICATION_NAME)
            .build();
    }
    
    public List<YoutubeVideo> searchVideos(String searchQuery) throws GeneralSecurityException, IOException, GoogleJsonResponseException{
        
        try{
        YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.Search.List request = youtubeService.search()
            .list("snippet");
        SearchListResponse response = request.setKey(DEVELOPER_KEY)
            .setMaxResults(25L)
            .setQ(searchQuery)
            .setType("video")
            .setFields("items(id/kind,id/videoId,snippet/title,snippet/description,snippet/thumbnails/default/url)")
            .execute();
        
        
        List<YoutubeVideo> vids = new ArrayList<>();
        
        List<SearchResult> resultList = response.getItems();
        
        for(SearchResult r : resultList){
            YoutubeVideo vid = new YoutubeVideo(YoutubeService.VIDEO_URL + r.getId().getVideoId(), 
                    r.getSnippet().getTitle(), 
                    r.getSnippet().getThumbnails().getDefault().getUrl(),
                    r.getSnippet().getDescription());
            vids.add(vid);
        }
        
        System.out.println(vids.toString());
        
        return vids;
        
        } catch (Exception e){
            e.printStackTrace();
            List<YoutubeVideo> emptyList = new ArrayList<>();
            return emptyList;
        }
        
    }

    /**
     * Call function to create API service object. Define and
     * execute API request. Print API response.
     *
     * @throws GeneralSecurityException, IOException, GoogleJsonResponseException
     */

}
