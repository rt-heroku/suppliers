package mx.towers.suppliers.repostiories;


import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.towers.suppliers.model.Types;

@Repository
public interface TypesRepository extends JpaRepository<Types, Integer> {

    // Custom query methods (if needed) can be added here.
    
    // Example: find by 'type' and 'name'
    Optional<Types> findByTypeAndName(String type, String name);
    
    
//    public List<Types> findbyType(String type);
    
}

