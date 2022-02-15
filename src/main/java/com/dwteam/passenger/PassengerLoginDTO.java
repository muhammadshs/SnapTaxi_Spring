package com.dwteam.passenger;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PassengerLoginDTO {
    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String userName;

    @ApiModelProperty(required = true, hidden = false)
    private String passWord;

}
