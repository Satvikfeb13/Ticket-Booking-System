package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Util.UserServiceUtil;
import org.example.entities.Ticket;
import org.example.entities.User;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
//    we store the user globally
    private User user;
    private List<User>userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USER_PATH = "app\\src\\main\\java\\org\\example\\localdb\\users.json";
    public  UserBookingService(User user1) throws  IOException{
        this.user=user1;
        loaduser();
    }
    public  UserBookingService() throws IOException{
        loaduser();
    }
    public List<User>loaduser() throws  IOException{
        // user just load  we will add all user to userlist
        File users = new File(USER_PATH);
        return objectMapper.readValue(users, new TypeReference<List<User>>() {});
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
    private   void saveUserListToFile()throws IOException{
        File userfile= new File(USER_PATH);
//        cerelization
        objectMapper.writeValue(userfile,userList);

    }
    public  void fetchBooking(){
        user.printickets();
    }
    public  Boolean cancelBooking(String ticketId)throws IOException{
        if (ticketId == null || ticketId.isEmpty()) {
            System.out.println("Ticket ID cannot be null or empty.");
            return Boolean.FALSE;
        }
        boolean isRemoved =  user.getTicketBooked().removeIf(ticket -> ticket.getTicketId().equals(ticketId) );
        if(isRemoved) {
            saveUserListToFile();
            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
            return true;
        }else{
            System.out.println("No ticket found with ID " + ticketId);
            return false;
        }
    }

}
