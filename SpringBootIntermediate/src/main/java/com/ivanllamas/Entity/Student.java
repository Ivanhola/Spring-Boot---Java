
package com.ivanllamas.Entity;

/*This class is going to be our Student entity, Which is going to have an id, name, and course*/
public class Student {
                         /* Encapsulated variables */
    private int id;
    private String name;
    private String course;
           /*Constructor that takes in an int for an ID, Name, and course*/
    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }
    
                         /*Default constructor*/
      public Student(){
        
    }

      
                        /*getters and setters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
  
    
    
}
