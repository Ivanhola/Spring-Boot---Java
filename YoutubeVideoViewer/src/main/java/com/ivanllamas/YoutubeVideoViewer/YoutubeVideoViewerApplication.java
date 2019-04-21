package com.ivanllamas.YoutubeVideoViewer;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.VideoListResponse;
import com.ivanllamas.YoutubeVideoViewer.service.YoutubeService;
import static com.ivanllamas.YoutubeVideoViewer.service.YoutubeService.getService;
import java.io.IOException;
import java.security.GeneralSecurityException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YoutubeVideoViewerApplication {

	public static void main(String[] args)  throws GeneralSecurityException, IOException, GoogleJsonResponseException {
		SpringApplication.run(YoutubeVideoViewerApplication.class, args);
                        YouTube youtubeService = getService();
        // Define and execute the API request
        YouTube.Videos.List request = youtubeService.videos()
            .list("snippet,contentDetails,statistics");
        VideoListResponse response = request.setKey(YoutubeService.DEVELOPER_KEY)
            .setId("TgqiSBxvdws")
            .execute();
        System.out.println(response);
	}

}
