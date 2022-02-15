package com.dwteam.transaction;

import com.dwteam.exception.ConflictExp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class TransactionService implements ITransactionService{
    TransactionRepository transactionRepository;

    @Override
    public void payment(Transaction transaction) {
        if (transactionRepository.existsByTrip(transaction.getTrip())){
            throw new ConflictExp("this trip have transaction");
        }
        transactionRepository.save(transaction);
    }
}
