package com.dwteam.passenger;

import com.dwteam.trip.Trip;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PassengerService implements IPassengerService{
    PassengerRepository passengerRepository;

    @Override
    public Long login(String userName, String passWord) {
        return null;
    }


    @Override
    public void changeState(Long id, Integer state) {
        Optional<Passenger> op=passengerRepository.findById(id);

        op.ifPresentOrElse(passenger1 -> {
            passenger1.setState(state);
            passengerRepository.save(passenger1);

        },//custom exception
                ()->{System.err.println("eeer");});


    }
}
