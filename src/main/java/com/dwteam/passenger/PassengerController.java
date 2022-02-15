package com.dwteam.passenger;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/Passenger")
public class PassengerController {
    private IPassengerService passengerService;
    private PassengerMapper passengerMapper;
    @PutMapping(value = "/register")
    public ResponseEntity<PassengerDTO> register(@RequestBody PassengerDTO passengerDTO){
        PassengerDTO passengerDTO1=passengerMapper.toDTO(passengerService.savePassenger(passengerMapper.toEntity(passengerDTO)));
        return ResponseEntity.ok(passengerDTO1);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<Long> login(@RequestBody PassengerLoginDTO passengerLoginDTO){
        Long id=passengerService.login(passengerLoginDTO.getUserName(), passengerLoginDTO.getPassWord());
        return ResponseEntity.ok(id);
    }

}
