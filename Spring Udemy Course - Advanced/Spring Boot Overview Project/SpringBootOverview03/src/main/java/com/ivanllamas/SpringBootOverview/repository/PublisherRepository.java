
package com.ivanllamas.SpringBootOverview.repository;

import com.ivanllamas.SpringBootOverview.entity.Publisher;
import org.springframework.data.repository.CrudRepository;


public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}
