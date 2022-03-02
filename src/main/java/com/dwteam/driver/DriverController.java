package com.dwteam.driver;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/Driver")
public class DriverController {
    IDriverService iDriverService;
    DriverMapper driverMapper;

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody DriverLoginDTO driverLoginDTO){
          String tokenStr=iDriverService.login(driverLoginDTO.getUserName(),driverLoginDTO.getPassWord());
        return ResponseEntity.ok(tokenStr);
    }

    @PutMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestBody DriverDTO driverDTO){
        DriverDTO d=driverMapper.toDTO(iDriverService.saveDriver(driverMapper.toEntity(driverDTO)));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
