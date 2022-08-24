package com.example.tarrifsandbalance.repository;

import com.example.tarrifsandbalance.models.User;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    boolean existsById(Long aLong);
}
