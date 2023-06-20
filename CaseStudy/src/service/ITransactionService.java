package service;

import model.Transaction;

import java.util.List;

public interface ITransactionService {
    List<Transaction> getAllTransaction();
    Transaction findTransaction(long id);
    void addTransaction(Transaction transaction);
}
