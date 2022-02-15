package com.dwteam.driver;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DriverLoginDTO {
    @ApiModelProperty(required = false, hidden = true)
    private Long id;
    @ApiModelProperty(required = true, hidden = false)
    private String userName;

    @ApiModelProperty(required = true, hidden = false)
    private String passWord;
}
