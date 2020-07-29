package com.example.Service;

import com.example.Entity.LoginInfoEntity;
import com.example.Repository.LogonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpLogonService {

    @Autowired
    private LogonRepository logonRepository;

    public void addLogonData(){

        LoginInfoEntity entity1 = new LoginInfoEntity();
        LoginInfoEntity entity2 = new LoginInfoEntity();

        entity1.setUserName("BTS");
        entity1.setPassword("bighit");

        entity2.setPassword("anupama");
        entity2.setPassword("adoni");

        logonRepository.save(entity1);
        logonRepository.save(entity2);
    }
}
