package org.example.entities;

import java.util.List;

public class User {
    private  String name;
    private String password;
    private  String userId;
    private String hashedPassword;
     private List<Ticket> ticketBooked;
     public  User(String name,String password,String hashedPassword,List<Ticket>ticketBooked,String userId){
         this.name=name;
         this.password=password;
         this.hashedPassword=hashedPassword;
         this.ticketBooked=ticketBooked;
         this.userId=userId;

     }
     public User(){};

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserId(){
        return userId;
    }
    public  void setUserId(String userId){
        this.userId=userId;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<Ticket> getTicketBooked() {
        return ticketBooked;
    }

    public void setTicketBooked(List<Ticket> ticketBooked) {
        this.ticketBooked = ticketBooked;
    }

    public  void printickets(){
        for (int i = 0; i <ticketBooked.size(); i++) {
            System.out.println(ticketBooked.get(i).getTicketInfo());
        }
    }










}
