
package com.ivanllamas.RetrievingRestAPIData.ApiEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageURL {

    public String url;
    
    public MessageURL(){
        
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MessageURL{" + "url=" + url + '}';
    }
    
    
}
