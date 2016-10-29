package fi.example.entity;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VastausCRUDRepo extends CrudRepository<Vastaus, Long> {
   
}