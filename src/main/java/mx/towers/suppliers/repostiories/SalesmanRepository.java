package mx.towers.suppliers.repostiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.towers.suppliers.sales.Salesman;

@Repository
public interface SalesmanRepository extends JpaRepository<Salesman, Integer> {
    // You can add custom methods if required
}