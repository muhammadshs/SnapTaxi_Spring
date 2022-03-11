package com.dwteam.passenger;

import com.dwteam.exceptions.ConflictExp;
import com.dwteam.exceptions.NotFindExp;
import com.dwteam.jwt.ConfigToken;
import com.dwteam.jwt.Token;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PassengerService implements IPassengerService{
    PassengerRepository passengerRepository;
    Token token;
    @Override
    public String login(String userName, String passWord) {
        Optional<Passenger> op=passengerRepository.findByUserNameAndPassWord(userName,passWord);
        if(op.isEmpty()){
            throw new NotFindExp("cant find Passenger",this.getClass().getName());
        }
        String tokenStr="";
        try {
            tokenStr=token.CreateToken_HS256_Person(userName,op.get().getId(), ConfigToken.secretToken);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return tokenStr;
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        if (passengerRepository.existsByUserNameOrPhoneNumber(passenger.getUserName(),passenger.getPhoneNumber())){
            throw new ConflictExp("this passenger exists",this.getClass().getName());
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
                ()->{throw new NotFindExp("Cant find Passenger with this id",this.getClass().getName());});


    }

}
