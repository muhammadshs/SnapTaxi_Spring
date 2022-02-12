package com.dwteam.transaction;

import com.dwteam.trip.Trip;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class TransactionDTO {
    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private Double amount;


    @ApiModelProperty(required = true, hidden = false)
    private Trip trip;

    @ApiModelProperty(required = true, hidden = false)
    private Date date;
}
