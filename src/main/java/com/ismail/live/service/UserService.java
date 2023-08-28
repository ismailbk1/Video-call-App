package com.ismail.live.service;

import com.ismail.live.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {

    private static final List<User> UserList=new ArrayList<>();

    public void register(User user){
        user.setStatus("online");
        UserList.add(user);
    }
    public User login(User user){
        var userIndex= IntStream.range(0, UserList.size()).filter(i->UserList.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(()->new RuntimeException("user Not Found"));

        var cUser=UserList.get(userIndex);
        if(!cUser.getPassword().equals(user.getPassword())) throw new RuntimeException("paword incorrect");
        cUser.setStatus("online");
        return cUser;
    }
    public void logOut(String email){
        var userIndex= IntStream.range(0, UserList.size()).filter(i->UserList.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()->new RuntimeException("user Not Found"));

        UserList.get(userIndex).setStatus("offLine");
    }
    public List<User> findAll(){
        return UserList;
    }
}
