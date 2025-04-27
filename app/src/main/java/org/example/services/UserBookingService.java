package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Util.UserServiceUtil;
import org.example.entities.User;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.io.IOException;

public class UserBookingService {
//    we store the user globally
    private User user;
    private List<User>userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USER_PATH = "app\\src\\main\\java\\org\\example\\localdb\\users.json";

    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        File users = new File(USER_PATH);
//        decentralization
        userList=objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }
    public  Boolean loginUser(){
        Optional<User>foundUser=userList.stream().filter(user1->{
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user1.getPassword(),user.getHashedPassword());
        }).findFirst();
        return foundUser.isEmpty();
    }
    public  boolean signup(User user1){
     try{
         userList.add(user1);
        saveUserListToFile();
            return  Boolean.TRUE;
     }catch (IOException e){
//         System.out.p;
         return Boolean.FALSE;
     }
    }
    public  void saveUserListToFile()throws IOException{
        File userfile= new File(USER_PATH);
//        cerelization
        objectMapper.writeValue(userfile,userList);

    }

}
