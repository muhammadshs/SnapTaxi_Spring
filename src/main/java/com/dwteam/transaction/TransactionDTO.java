package com.dwteam.transaction;


import com.dwteam.trip.TripDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TransactionDTO {
    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private Double amount;


    @ApiModelProperty(required = true, hidden = false)
    private TripDTO tripDTO;

    @ApiModelProperty(required = true, hidden = false)
    private Date date;
}
