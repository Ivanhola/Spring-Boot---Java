package com.ivanllamas.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "visits")
public class Visit extends BaseEntity{

@Column(name = "date")
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate date;

@Column(name = "description")
private String description;

//the 'owning' column of the relationship
@ManyToOne
@JoinColumn(name = "pet_id")
private Pet pet;


    //constructor


    public Visit() {
    }

    public Visit(LocalDate date, String description, Pet pet) {
        this.date = date;
        this.description = description;
        this.pet = pet;
    }
    
    

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    
}