package com.example.tarrifsandbalance.repository;

import com.example.tarrifsandbalance.models.Card;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.repository.CrudRepository;

@N1qlPrimaryIndexed
public interface CardRepository extends CrudRepository<Card,Integer> {
}
