package com.example.tarrifsandbalance.repository;


import com.example.tarrifsandbalance.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,Long> {
}
