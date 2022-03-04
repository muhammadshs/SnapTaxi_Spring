package com.dwteam.passenger;

import com.dwteam.jwt.TokenDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/passenger")
public class PassengerController {
    private IPassengerService passengerService;
    private PassengerMapper passengerMapper;
    @PutMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestBody PassengerDTO passengerDTO){
        passengerService.savePassenger(passengerMapper.toEntity(passengerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping(value = "/login")
    public ResponseEntity<TokenDTO> login(@RequestBody PassengerLoginDTO passengerLoginDTO){
        String tokenStr=passengerService.login(passengerLoginDTO.getUserName(), passengerLoginDTO.getPassWord());
        TokenDTO tokenDTO=new TokenDTO();
        tokenDTO.setToken(tokenStr);
        return ResponseEntity.ok(tokenDTO);
    }

}
