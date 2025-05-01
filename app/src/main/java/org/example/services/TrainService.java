package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Util.UserServiceUtil;
import org.example.entities.Ticket;
import org.example.entities.Train;
import org.example.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrainService {
    private Train train;
    private List<Train> trainList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAIN_PATH = "app\\src\\main\\java\\org\\example\\localdb\\trains.json";

    public  TrainService() throws IOException {
        loadtrain();
    }

    public TrainService(Train train1) throws IOException {
        this.train = train1;
        loadtrain();
    }

    public List<Train> loadtrain() throws IOException {
        File train = new File(TRAIN_PATH);
        return objectMapper.readValue(train, new TypeReference<List<Train>>() {
        });
    }

    public List<Train> searchTrains(String source, String destination) {
        return trainList.stream().filter(train1 -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    public boolean validTrain(Train train, String source, String destnation) {
        List<String> stationOrder = train.getStations();
        int sourceindex = stationOrder.indexOf(source.toLowerCase());
        int destinationindex = stationOrder.indexOf(destnation.toLowerCase());
        return sourceindex != -1 && destinationindex != -1 && sourceindex < destinationindex;
    }
}



