package com.nickglas.gc.Code.generation.repositories;

import com.nickglas.gc.Code.generation.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
