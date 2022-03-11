package com.dwteam.reserve;

import com.dwteam.person.PersonLoginCon;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reserve")
@AllArgsConstructor
public class ReserveController {
    IReserveService iReserveService;
    PersonLoginCon personLoginCon;
    @PostMapping(value = "/end_trip")
    public ResponseEntity<Void> endTrip(/*@RequestBody Long passengerId*/){
        iReserveService.endTrip(personLoginCon.getId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping(value = "/change_driver")
    public ResponseEntity<Void> changeDriver(@RequestBody Long tripId){
        iReserveService.changeDriver(tripId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping(value = "/cancle_trip")
    public ResponseEntity<Void> cancleTrip(@RequestBody Long tripId){
        iReserveService.cancelTrip(tripId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
