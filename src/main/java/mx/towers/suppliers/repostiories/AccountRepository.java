package mx.towers.suppliers.repostiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.towers.suppliers.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	 public List<Account> findByAccountType(Integer accountType);
	
    // Custom query methods (if needed) can be added here.
}
