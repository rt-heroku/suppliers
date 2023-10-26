package mx.towers.suppliers.repostiories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.towers.suppliers.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    // You can add custom methods if required. For example:
    // Optional<Bank> findByBanco(String banco);
}