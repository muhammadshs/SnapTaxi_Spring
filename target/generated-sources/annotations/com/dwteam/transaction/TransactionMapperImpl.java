package com.dwteam.transaction;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-04T20:50:18+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public Transaction toEntity(TransactionDTO transactionDTO) {
        if ( transactionDTO == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setId( transactionDTO.getId() );
        transaction.setAmount( transactionDTO.getAmount() );
        transaction.setDate( transactionDTO.getDate() );

        return transaction;
    }

    @Override
    public TransactionDTO toDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setId( transaction.getId() );
        transactionDTO.setAmount( transaction.getAmount() );
        transactionDTO.setDate( transaction.getDate() );

        return transactionDTO;
    }
}
