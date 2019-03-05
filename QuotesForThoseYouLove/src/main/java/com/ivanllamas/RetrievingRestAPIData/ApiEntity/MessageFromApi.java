
package com.ivanllamas.RetrievingRestAPIData.ApiEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageFromApi {

    private String message;
    private String subtitle;
    
    public MessageFromApi(){
        
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @Override
    public String toString() {
        return "MessageFromApi{" + "message=" + message + ", subtitle=" + subtitle + '}';
    }
    
    
}
