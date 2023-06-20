package service;

import config.Config;
import model.Transaction;
import utils.FileUtils;

import java.util.List;

public class TransactionService implements ITransactionService{
    private final String pathTransaction = "F:\\Module2\\CaseStudy\\data\\transaction.csv";
    @Override
    public List<Transaction> getAllTransaction() {
        return FileUtils.readFile(pathTransaction, Config.TYPE_TRANSACTION);
    }

    @Override
    public Transaction findTransaction(long id) {
        List<Transaction> transactions = FileUtils.readFile(pathTransaction, Config.TYPE_TRANSACTION);
        for(Transaction t : transactions){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        List<Transaction> transactions = FileUtils.readFile(pathTransaction, Config.TYPE_TRANSACTION);
        transactions.add(transaction);
        FileUtils.writeFile(transactions, pathTransaction);
    }
}
