package mx.towers.suppliers.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_info")
public class BankInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // other fields...

    @OneToMany(mappedBy = "bankInfo")
    private Set<Payment> payments;

    @Column(name = "bank_id", nullable = false)
    private int bankId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "routing")
    private String routing;

    @Column(nullable = false)
    private boolean active;

    @Column(name = "max_amount", nullable = false)
    private double maxAmount;

    @Column(nullable = false)
    private int country;

    @Column(name = "is_clabe")
    private Boolean isClabe;

    @Column(name = "account_id", nullable = false)
    private int accountId;

    // Assuming there's a related entity named Account:
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;

    
    
    // getters, setters, and other methods...



}