package com.dwteam.person;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PersonLoginService {
    private PersonLoginCon personLoginCon;
    public void setter (Long id,String userName){
        personLoginCon.setId(id);
        personLoginCon.setUserName(userName);
    }
    public String getUserName(){
        return personLoginCon.getUserName();
    }
    public Long getId(){
        return personLoginCon.getId();
    }
}
