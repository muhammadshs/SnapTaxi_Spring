package com.dwteam.passenger;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
@Data
public class PassengerDTO {
    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String userName;

    @ApiModelProperty(required = true, hidden = false)
    private String passWord;

    @ApiModelProperty(required = true, hidden = false)
    private Long phoneNumber;

    @ApiModelProperty(required = true, hidden = false)
    private Integer state;

    @ApiModelProperty(required = true, hidden = false)
    private Double balance;
}
