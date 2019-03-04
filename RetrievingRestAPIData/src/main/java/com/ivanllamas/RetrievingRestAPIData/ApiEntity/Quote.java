
package com.ivanllamas.RetrievingRestAPIData.ApiEntity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*Any properties that are not bound to a Quote object should be ignored*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    //we need to make the variables exactly as they are in the retrieved API JSON
    
    private String type;
    private Value value;
    
    //Default constructor
    
    public Quote(){
        
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" + "type=" + type + ", value=" + value + '}';
    }
    
    
    
    
}
