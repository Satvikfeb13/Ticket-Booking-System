package org.example.entities;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private String userId;
    private String source;
    private String destination;
    private Date dateOfTravel;
    private  Train train;
    public  String getTicketId(){
        return ticketId;
    }
    public  void  setTicketId(String ticketId){
        this.ticketId=ticketId;
    }
    public  String getUserId(){
        return userId;
    }
    public  void  getUserId(String userId){
        this.userId=userId;
    }
    public  String getSource(){
        return source;
    }
    public  void  setSource(String source){
        this.source=source;
    }
    public  String getDestination(){
        return destination;
    }
    public  void  setDestination(String destination){
        this.destination=destination;
    }






}
