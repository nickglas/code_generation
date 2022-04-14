package com.nickglas.gc.Code.generation.services;

import com.nickglas.gc.Code.generation.interfaces.TransactionInterface;
import com.nickglas.gc.Code.generation.models.Transaction;
import com.nickglas.gc.Code.generation.repositories.TransactionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements TransactionInterface {

    private final TransactionRepo transactionRepo;

    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionRepo.findAll();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepo.getById(id);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepo.save(transaction);
    }


}
