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
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrainService {
    private  Train train;
    private List<Train> trainList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String TRAIN_PATH = "app\\src\\main\\java\\org\\example\\localdb\\trains.json";

    public  TrainService() throws IOException {
        File trains = new File(TRAIN_PATH);
         objectMapper.readValue(trains, new TypeReference<List<Train>>() {});
    }
    
    public List<Train> searchTrains(String source, String destination) {
        return trainList.stream().filter(train1 -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    public  void addTrain(Train newTrain){
        Optional<Train>existingtrain=trainList.stream().filter(train1 ->
            train1.getTrainId().equalsIgnoreCase(newTrain.getTrainId())
        ).findFirst();
        if(existingtrain.isPresent()){
            updateTrain(newTrain);
        }else{
            trainList.add(newTrain);
            saveTrainListToFile();
        }
    }
    public  void updateTrain(Train updatetrain){
        OptionalInt index= IntStream.range(0,trainList.size()).
                filter(i->trainList.get(i).getTrainId().equalsIgnoreCase(updatetrain.getTrainId())).
                findFirst();
        if(index.isPresent()){
            trainList.set(index.getAsInt(),updatetrain);
            saveTrainListToFile();
        }else {
            addTrain(updatetrain);
        }
    }

    private void saveTrainListToFile() {
        try{
            objectMapper.writeValue(new File(TRAIN_PATH),trainList);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public boolean validTrain(Train train, String source, String destnation) {
        List<String> stationOrder = train.getStations();
        int sourceindex = stationOrder.indexOf(source.toLowerCase());
        int destinationindex = stationOrder.indexOf(destnation.toLowerCase());
        return sourceindex != -1 && destinationindex != -1 && sourceindex < destinationindex;
    }
}



