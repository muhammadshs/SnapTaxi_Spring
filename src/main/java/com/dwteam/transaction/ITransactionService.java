package com.dwteam.transaction;

import com.dwteam.trip.Trip;

import java.util.Date;

public interface ITransactionService {
    void payment(Double amount, Date date, Trip trip);
}
