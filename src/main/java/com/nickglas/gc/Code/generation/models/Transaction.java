package com.nickglas.gc.Code.generation.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String toIban;
    private String fromIban;
    private Timestamp timestamp;
    private TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(String toIban, String fromIban, TransactionType transactionType) {
        this.toIban = toIban;
        this.fromIban = fromIban;
        this.timestamp = Timestamp.from(Instant.now());
        this.transactionType = transactionType;
    }

    public Transaction(Long id, String toIban, String fromIban, TransactionType transactionType) {
        this(toIban, fromIban, transactionType);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToIban() {
        return toIban;
    }

    public void setToIban(String toIban) {
        this.toIban = toIban;
    }

    public String getFromIban() {
        return fromIban;
    }

    public void setFromIban(String fromIban) {
        this.fromIban = fromIban;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", toIban='" + toIban + '\'' +
                ", fromIban='" + fromIban + '\'' +
                ", timestamp=" + timestamp +
                ", transactionType=" + transactionType +
                '}';
    }
}
