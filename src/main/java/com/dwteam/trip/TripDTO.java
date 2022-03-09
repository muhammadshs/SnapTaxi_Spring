package com.dwteam.trip;

import com.dwteam.driver.DriverDTO;
import com.dwteam.passenger.PassengerDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
public class TripDTO {

    @ApiModelProperty(required = true, hidden = false)
    private Double price;

    @ApiModelProperty(required = true, hidden = false)
    private PassengerDTO passenger;

    @ApiModelProperty(required = true, hidden = false)
    private DriverDTO driverDTO;

    @ApiModelProperty(required = false, hidden = false)
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


}
