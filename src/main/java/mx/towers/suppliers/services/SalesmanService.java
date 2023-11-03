package mx.towers.suppliers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.towers.suppliers.repostiories.SalesmanRepository;
import mx.towers.suppliers.sales.Salesman;

@Service
public class SalesmanService {

    private final SalesmanRepository salesmanRepository;

    @Autowired
    public SalesmanService(SalesmanRepository salesmanRepository) {
        this.salesmanRepository = salesmanRepository;
    }

    public List<Salesman> getAllSalesmen() {
        return salesmanRepository.findAll();
    }

    public Optional<Salesman> getSalesmanById(int id) {
        return salesmanRepository.findById(id);
    }

    public Salesman saveSalesman(Salesman salesman) {
        return salesmanRepository.save(salesman);
    }

    public void deleteSalesman(int id) {
        salesmanRepository.deleteById(id);
    }

    // any other service methods you might need...
}
