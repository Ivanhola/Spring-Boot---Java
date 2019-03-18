
package com.ivanllamas.services.springdatajpa;

import com.ivanllamas.entity.Vet;
import com.ivanllamas.repository.VetRepository;
import com.ivanllamas.services.VetService;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService{
    
    private final VetRepository vetRepository;

    @Autowired
    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }
    
    

    @Override
    public Set<Vet> findAll() {
     return (Set<Vet>) vetRepository.findAll();
    }

    @Override
    public Vet findById(Long id) {
        Optional<Vet> vetOptional = vetRepository.findById(id);
        if(vetOptional.isPresent()){
            return vetOptional.get();
        }else{
            return null;
        }
        
       }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

}
