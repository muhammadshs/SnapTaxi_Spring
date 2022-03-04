package com.dwteam.driver;

import com.dwteam.jwt.TokenDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/driver")
public class DriverController {
    IDriverService iDriverService;
    DriverMapper driverMapper;

    @PostMapping(value = "/login")
    public ResponseEntity<TokenDTO> login(@RequestBody DriverLoginDTO driverLoginDTO){
          String tokenStr=iDriverService.login(driverLoginDTO.getUserName(),driverLoginDTO.getPassWord());
        TokenDTO tokenDTO=new TokenDTO();
        tokenDTO.setToken(tokenStr);
        return ResponseEntity.ok(tokenDTO);
    }

    @PutMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestBody DriverDTO driverDTO){
        iDriverService.saveDriver(driverMapper.toEntity(driverDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
