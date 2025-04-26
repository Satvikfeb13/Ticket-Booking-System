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
}
