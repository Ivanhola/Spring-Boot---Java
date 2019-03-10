package com.ivanllamas.services;

import com.ivanllamas.entity.Vet;
import java.util.Set;

//this will be the service we use for our Vet entity to perform CRUD operations
public interface VetService {
   Vet findById(Long id);
   Vet save(Vet vet);
   Set<Vet> findAll();
}
