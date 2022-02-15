package com.dwteam.passenger;

import com.dwteam.exception.ConflictExp;
import com.dwteam.exception.NotFindExp;
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
        Optional<Passenger> op=passengerRepository.findByUserNameAndPassWord(userName,passWord);
        if(op.isEmpty()){
            throw new NotFindExp("cant find Passenger");
        }
        return op.get().getId();
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        if (passengerRepository.existsByUserNameOrPhoneNumber(passenger.getUserName(),passenger.getPhoneNumber())){
            throw new ConflictExp("this passenger exists");
        }
        return passengerRepository.save(passenger);
    }


    @Override
    public void changeState(Long id, Integer state) {
        Optional<Passenger> op=passengerRepository.findById(id);

        op.ifPresentOrElse(passenger1 -> {
            passenger1.setState(state);
            passengerRepository.save(passenger1);

        },//custom exception
                ()->{throw new NotFindExp("Cant find Passenger with this id");});


    }
}
