package mx.towers.suppliers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.towers.suppliers.model.Bank;
import mx.towers.suppliers.repostiories.BankRepository;

@Service
public class BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Optional<Bank> getBankById(int id) {
        return bankRepository.findById(id);
    }

    public Bank saveBank(Bank bank) {
        return bankRepository.save(bank);
    }

    public void deleteBank(int id) {
        bankRepository.deleteById(id);
    }
    
    // any other service methods you might need. For example:
    // public Optional<Bank> getBankByBanco(String banco) {
    //     return bankRepository.findByBanco(banco);
    // }
}