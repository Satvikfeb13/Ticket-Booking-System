package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Util.UserServiceUtil;
import org.example.entities.Ticket;
import org.example.entities.Train;
import org.example.entities.User;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class UserBookingService {
//    we store the user globally
    private User user;
    private List<User>userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private final String USER_PATH = "app/src/main/java/org/example/localdb/users.json";
    public UserBookingService(User user) throws IOException {
        this.user = user;
        this.userList = loadUsers();
    }
    public UserBookingService() throws IOException {
        this.userList = loadUsers();
    }

    private List<User> loadUsers() throws IOException {
        File usersFile = new File(USER_PATH);
        if (!usersFile.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(usersFile, new TypeReference<List<User>>() {});
    }

    public  Boolean loginUser(){
        Optional<User>foundUser=userList.stream().filter(user1->{
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user1.getPassword(),user.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }
    public  boolean signup(User user1)throws  IOException{
     try{
         Optional<User> foundUser = userList.stream().filter(user2 ->
                 user2.getName().equals(user1.getName()) &&
                         UserServiceUtil.checkPassword(user2.getPassword(), user1.getHashedPassword())
         ).findFirst();

         if(foundUser.isPresent()){
             System.out.println("Username is already taken");
             return  false;
         }
         userList.add(user1);
         saveUserListToFile();
     }catch (Exception ex){
         System.out.println("saving user list to file failed " + ex.getMessage());
         return false;
     }
        return true;
    }
    public  void saveUserListToFile()throws IOException{
       try {
           objectMapper.writeValue(new File(USER_PATH),userList);
       }catch (IOException e){
           e.printStackTrace();
       }


    }
    public  void fetchBooking(){
        Optional<User>userfetched= userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user1.getPassword(),user.getHashedPassword());
        }).findFirst();
        if(userfetched.isPresent()){
            userfetched.get().printickets();
        }
    }
    public  Boolean cancelBooking(String ticketId)throws IOException{
        if (ticketId == null || ticketId.isEmpty()) {
            System.out.println("Ticket ID cannot be null or empty.");
            return Boolean.FALSE;
        }
        boolean isRemoved =  user.getTicketBooked().removeIf(ticket -> ticket.getTicketId().equals(ticketId) );
        if(isRemoved) {
            saveUserListToFile();
            System.out.println("Ti+cket with ID " + ticketId + " has been canceled.");
            return true;
        }else{
            System.out.println("No ticket found with ID " + ticketId);
            return false;
        }
    }

    public  List<Train>getTrains(String source,String destination) throws IOException {
        try{
            TrainService trainService= new TrainService();
            return trainService.searchTrains(source,destination);
        }catch (IOException ex){
            return  new ArrayList<>();
        }

    }
    public List<List<Integer>>fetchSeats(Train train){
        return train.getSeats();
    }
    public Boolean bookTrainSeat(Train train,int row, int seat){
        try{
            TrainService trainService= new TrainService();
            List<List<Integer>>seats= train.getSeats();
            if (row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()){
                if(seats.get(row).get(seat)==0){
                    seats.get(row).set(seat,1);
                    train.setSeats(seats);
                    trainService.addTrain(train);
                    return true;
                }else {
                    return  false;
                }
            }else {
                return false;
            }

        }catch (IOException i){
            return Boolean.FALSE;

        }
    }

}
