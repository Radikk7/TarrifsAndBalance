package com.example.tarrifsandbalance.service;

import ch.qos.logback.core.net.ObjectWriter;
import com.example.tarrifsandbalance.models.Balance;
import com.example.tarrifsandbalance.models.Tariff;
import com.example.tarrifsandbalance.models.User;
import com.example.tarrifsandbalance.repository.BalanceRepository;
import com.example.tarrifsandbalance.repository.CardRepository;
import com.example.tarrifsandbalance.repository.TariffRepository;
import com.example.tarrifsandbalance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserService {
    @Autowired
    TariffRepository tariffRepository;
    @Autowired
    BalanceRepository balanceRepository;
    @Autowired
    UserRepository userRepository;
  //  @Autowired
  //  CardRepository cardRepository;

    public void usersGenerator(Integer count){
        List<Tariff>tariffList = generateRandomTariff();
        for (int i = 0; i < count;i++){
            Set<Tariff>tariffSet = new HashSet<>();
            tariffSet.add(tariffList.get((int)(Math.random() *tariffList.size())));
            tariffSet.add(tariffList.get((int)(Math.random() *tariffList.size())));
            User user = new User();
            user.setLogin(generateLogin());
            user.setTariffSet(tariffSet);
            user.setBalance(generateRandomBalance());
            userRepository.save(user);
        }
    }
    public Balance generateRandomBalance(){
        Balance balance = new Balance();
        balance.setValue((int)(Math.random() * 100));
        balanceRepository.save(balance);
        return balance;
    }
    public List<Tariff> generateRandomTariff(){
       List<Tariff>tariffList = new ArrayList<>();
       List<String> tariffNames = List.of("Cola","Pepsi","Coca-Cola","Fanta","Sprite","Mirinda","Coca-cola Vanila","Pepsi Blue","Doctor Peper","Mountain Dew");
       List<String> prices = List.of("10","22","12","133","9","8","5","16","30","19");
       for (int i =0;i < 10;i++){
            Tariff tariff = new Tariff();
            tariff.setNameTariff(tariffNames.get(i));
            tariff.setPrice(prices.get(i));
            tariffRepository.save(tariff);
            tariffList.add(tariff);
        }
        return tariffList;
    }
    public String generateLogin(){
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(uuid.length()/2);
    }




    @Transactional
    public List<User>getUsers(){
        return userRepository.findAll();
    }

    //public User returnuser(@PathVariable(name = "id") Long id){
    //       return  userRepository.findById(id).get();
    //    }

    public User returnUser(Long id){
        User user = userRepository.findById(id).get();
        if (userRepository.existsById(id)){
            return null;
        }
        return user;
    }

    public Balance addBalance(Balance balance){
        return balanceRepository.save(balance);
    }
    public Tariff addTariff(Tariff tariff){
        return  tariffRepository.save(tariff);
    }


}
