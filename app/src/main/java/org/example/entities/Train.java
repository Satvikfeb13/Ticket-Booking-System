package org.example.entities;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNo;
    private Date departTime;
    private Date arrivalTime;
    private  List<List<Boolean>>seat;
    private Map<String, Time>stationTimes;
    private List<String>stations;

    public String getTrainId() {
        return trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }
    public List<List<Boolean>> getSeat() {
        return seat;
    }

    public Map<String, Time> getStationTimes() {
        return stationTimes;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    public void setSeat(List<List<Boolean>> seat) {
        this.seat = seat;
    }

    public void setStationTimes(Map<String, Time> stationTimes) {
        this.stationTimes = stationTimes;
    }
    public  void setStations(List<String>stations){
        this.stations=stations;
    }

}
