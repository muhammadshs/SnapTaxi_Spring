package com.dwteam.trip;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/trip")
public class TripController {
    private ITripService iTripService;
    private TripMapper tripMapper;
    @PutMapping(value = "/creatTrip")
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripDTO tripDTO){
        TripDTO tripDTO1=tripMapper.toDTO(iTripService.creatTrip(tripMapper.toEntity(tripDTO)));
        return ResponseEntity.ok(tripDTO1);
    }
   @PostMapping(value = "/changePrice")
    public ResponseEntity<Void> changePrice(@RequestParam Long id){
        iTripService.changePrice(id);
       return ResponseEntity.status(HttpStatus.OK).build();
   }

}
