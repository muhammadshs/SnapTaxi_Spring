package com.dwteam.transaction;

import com.dwteam.trip.TripMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = TripMapper.class )
public interface TransactionMapper {
    Transaction toEntity(TransactionDTO transactionDTO);
    TransactionDTO toDTO(Transaction transaction);
}
