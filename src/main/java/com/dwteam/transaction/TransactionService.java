package com.dwteam.transaction;

import com.dwteam.trip.Trip;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
@AllArgsConstructor
@Service
public class TransactionService implements ITransactionService{
    TransactionRepository transactionRepository;

    @Override
    public void payment(Double amount, Date date, Trip trip) {
        Transaction transaction=new Transaction();
        transaction.setDate(date);
        transaction.setAmount(amount);
        transaction.setTrip(trip);
        transactionRepository.save(transaction);
    }
}
