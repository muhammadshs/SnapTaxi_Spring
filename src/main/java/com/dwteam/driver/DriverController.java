package com.dwteam.driver;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/Driver")
public class DriverController {
    IDriverService iDriverService;
    DriverMapper driverMapper;
    //response entity
    //convert enter value to map
    @PostMapping(value = "/login")
    public Long login(@RequestBody DriverDTO driverDTO){
        return iDriverService.login(driverDTO.getUserName(),driverDTO.getPassWord());
    }
    // problem in dto and convert to entity
    @PutMapping(value = "/register")
    public DriverDTO register(@RequestBody DriverDTO driverDTO){
        return driverMapper.toDTO(iDriverService.saveDriver(driverMapper.toEntity(driverDTO)));
    }
}
