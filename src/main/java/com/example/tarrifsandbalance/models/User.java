package com.example.tarrifsandbalance.models;


import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@XmlRootElement(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    @OneToOne(cascade = CascadeType.ALL)
    private Balance balance;
    @OneToMany(cascade = CascadeType.ALL,fetch =FetchType.EAGER)
    @JoinTable(name = "user_tariff", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tariff_id", referencedColumnName = "id"))
    private Set<Tariff>tariffSet;


    public User() {
    }

    public User(Long id, String login, Balance balance, Set<Tariff> tariffSet) {
        this.id = id;
        this.login = login;
        this.balance = balance;
        this.tariffSet = tariffSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public Set<Tariff> getTariffSet() {
        return tariffSet;
    }

    public void setTariffSet(Set<Tariff> tariffSet) {
        this.tariffSet = tariffSet;
    }
}
