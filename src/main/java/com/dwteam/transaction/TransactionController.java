package com.dwteam.transaction;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/transaction")
public class TransactionController {
    ITransactionService iTransactionService;
    TransactionMapper transactionMapper;
    @PutMapping(value = "/transaction")
    public ResponseEntity<Void> payment(TransactionDTO transactionDTO){
        iTransactionService.payment(transactionMapper.toEntity(transactionDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
