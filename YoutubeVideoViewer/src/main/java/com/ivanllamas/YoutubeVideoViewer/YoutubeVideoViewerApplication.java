package com.ivanllamas.YoutubeVideoViewer;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import static com.ivanllamas.YoutubeVideoViewer.service.YoutubeService.DEVELOPER_KEY;
import static com.ivanllamas.YoutubeVideoViewer.service.YoutubeService.getService;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.google.api.services.youtube.model.SearchListResponse;
import com.ivanllamas.YoutubeVideoViewer.entity.YoutubeVideo;
import com.google.api.services.youtube.model.SearchResult;
import com.ivanllamas.YoutubeVideoViewer.service.YoutubeService;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class YoutubeVideoViewerApplication {

        
	public static void main(String[] args)  throws GeneralSecurityException, IOException, GoogleJsonResponseException {
		SpringApplication.run(YoutubeVideoViewerApplication.class, args);        
                YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.Search.List request = youtubeService.search()
            .list("snippet");
        SearchListResponse response = request.setKey(DEVELOPER_KEY)
            .setMaxResults(25L)
            .setQ("pewdiepie")
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
        
        
	}

}
