package mx.towers.suppliers.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String banco;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "initial_date")
    private Date initialDate;

    @Column(name = "end_date")
    private Date endDate;

    // getters, setters, and other methods...
}