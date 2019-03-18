
package com.ivanllamas.services.springdatajpa;

import com.ivanllamas.entity.Visit;
import com.ivanllamas.repository.VisitRepository;
import com.ivanllamas.services.VisitService;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService{

    private final VisitRepository visitRepository;

    @Autowired
    public VisitSDJpaService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }
    
    
    
    @Override
    public Set<Visit> findAll() {
       
        return (Set<Visit>) visitRepository.findAll();
    }

    @Override
    public Visit findById(Long id) {
        Optional<Visit> visitOptional = visitRepository.findById(id);
        if(visitOptional.isPresent()){
           return visitOptional.get();
        }else{
            return null;
        }
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
    
    

}
