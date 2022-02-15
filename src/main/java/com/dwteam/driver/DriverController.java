package com.dwteam.driver;

import lombok.AllArgsConstructor;
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
    public ResponseEntity<Long> login(@RequestBody DriverLoginDTO driverLoginDTO){
        Long id=iDriverService.login(driverLoginDTO.getUserName(),driverLoginDTO.getPassWord());
        return ResponseEntity.ok(id);
    }

    @PutMapping(value = "/register")
    public ResponseEntity<DriverDTO> register(@RequestBody DriverDTO driverDTO){
        DriverDTO d=driverMapper.toDTO(iDriverService.saveDriver(driverMapper.toEntity(driverDTO)));
        return ResponseEntity.ok(d);
    }
}
