package com.example.tarrifsandbalance.repository;


import com.example.tarrifsandbalance.models.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffRepository extends JpaRepository<Tariff,Long> {
}
