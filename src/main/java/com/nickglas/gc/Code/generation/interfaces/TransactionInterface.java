package com.nickglas.gc.Code.generation.interfaces;

import com.nickglas.gc.Code.generation.models.Transaction;

import java.util.List;

public interface TransactionInterface {
    List<Transaction> getTransactions();
    Transaction getTransactionById(Long id);
    Transaction createTransaction(Transaction transaction);
}
