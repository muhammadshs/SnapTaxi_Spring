package com.dwteam.trip;

import com.dwteam.driver.Driver;
import com.dwteam.passenger.Passenger;
import com.dwteam.transaction.Transaction;
import io.swagger.annotations.ApiModelProperty;
import jdk.jfr.Timestamp;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
public class TripDTO {
    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private Double price;

    @ApiModelProperty(required = true, hidden = false)
    private Passenger passenger;

    @ApiModelProperty(required = true, hidden = false)
    private Driver driver;

    @ApiModelProperty(required = true, hidden = false)
    private Integer state;

    @ApiModelProperty(required = true, hidden = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatDate;

    @ApiModelProperty(required = true, hidden = false)
    private Double sourceLat;

    @ApiModelProperty(required = true, hidden = false)
    private Double sourceLong;

    @ApiModelProperty(required = true, hidden = false)
    private Double targetLat;

    @ApiModelProperty(required = true, hidden = false)
    private Double targetLong;

    @ApiModelProperty(required = true, hidden = false)
    private Transaction transaction;


}
