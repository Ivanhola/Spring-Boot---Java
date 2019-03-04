
package com.ivanllamas.RetrievingRestAPIData.ApiEntity;

/* As we can see, the Retrieved JSON value has 2 types of 'Objects', after the comma, theres a value:
followed by curly braces to indicated values for the other 'object' which is why we made this class

{
   type: "success",
   value: {
      id: 10,
      quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
   }

}


*/

// the value has 2 properties, id and quote
public class Value {

    
    //variables matching the properties
    private long id;
    private String quote;
    
    
    //default constructor
    public Value(){
    
    }
    
    
    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "Value{" + "id=" + id + ", quote=" + quote + '}';
    }
    
    
}
