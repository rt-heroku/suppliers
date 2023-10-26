package mx.towers.suppliers.repostiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.towers.suppliers.model.Account;
import mx.towers.suppliers.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	List<Payment> findByAccount(Account account);
	
	List<Payment> findByAccountId(Integer i);
	
}