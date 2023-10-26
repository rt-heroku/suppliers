package mx.towers.suppliers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.towers.suppliers.model.Account;
import mx.towers.suppliers.model.Payment;
import mx.towers.suppliers.repostiories.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public List<Payment> findByAccountId(Integer id) {
        return paymentRepository.findByAccountId(id);
    }
    public List<Payment> findByAccount(Account account) {
    	return paymentRepository.findByAccount(account);
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
    
    // any other service methods you might need...
}