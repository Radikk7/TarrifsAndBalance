package com.example.tarrifsandbalance.controller;

import com.example.tarrifsandbalance.models.Balance;
import com.example.tarrifsandbalance.models.Tariff;
import com.example.tarrifsandbalance.models.User;
import com.example.tarrifsandbalance.repository.BalanceRepository;
import com.example.tarrifsandbalance.repository.TariffRepository;
import com.example.tarrifsandbalance.repository.UserRepository;
import com.example.tarrifsandbalance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    BalanceRepository balanceRepository;

    @PostMapping("/")
    public ResponseEntity<String> addTariff(@RequestBody Tariff tariff){
        if(tariff.getNameTariff()==null){
            return new ResponseEntity<String>("Not Tariff",HttpStatus.NOT_FOUND);
        }
        else if(tariff.getPrice()==null){
            return new ResponseEntity<String>("Not Tariff price",HttpStatus.NOT_FOUND);
        }
        else if (userService.addTariff(tariff) != null){
            return new ResponseEntity<String>(String.valueOf(tariff),HttpStatus.OK);
        }
        return new ResponseEntity<>("Eror",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/addbalance")
    public ResponseEntity<String>addBalance(@RequestBody Balance balance) {
        if (balance.getValue() <= 0) {
            return new ResponseEntity<String>("Enter the correct number", HttpStatus.NOT_FOUND);
        }
        if (userService.addBalance(balance) != null) {
            return new ResponseEntity<String>(String.valueOf(balance), HttpStatus.OK);
        }
        return new ResponseEntity<>("Eror",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user){
       // System.out.println(user);
       //  userRepository.save(user);
        //  balanceRepository.save(balance);
        // tariffRepository.save(tariff);

    }
    @GetMapping("/returnuser/{id}")
    public User returnuser(@PathVariable(name = "id") Long id){
      return userService.returnUser(id);
    }

    @GetMapping("/usergenerate/{count}")
    public void userGenerate(@PathVariable(name = "count")Integer count){
        userService.usersGenerator(count);
    }
    //Написать функцию которая возвращает  юзеров  в формате json и xml
    @GetMapping(value = "/allusers",produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<User>> getusers(){
        List<User>userList= userService.getUsers();
        if (userList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }
    // написать функцию которая оотдает один баланс в формате XML
    // запрос на поиск в гугле unmarshaller java example list  github
        @GetMapping(value = "/onlybalance/{id}",produces = {MediaType.APPLICATION_XML_VALUE})
            public ResponseEntity<Balance> onlybalance(@PathVariable(name = "id") Long id){
           Balance balance= balanceRepository.findById(id).get();
           if (balance.getValue() == 0){
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
           else {
               return new ResponseEntity<>(balance,HttpStatus.OK);
           }
        }



}



