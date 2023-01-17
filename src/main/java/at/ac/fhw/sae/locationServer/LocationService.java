package at.ac.fhw.sae.locationServer;

import at.ac.fhw.sae.lesson4.SaePoint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Service

public class LocationService {

    Hashtable<Integer, List<SaePoint>> locations = new Hashtable<>();
    public void addLocation(int id, SaePoint saePoint) {
        List<SaePoint> saePoints = new ArrayList<>();
        if (locations.containsKey(id)){
            saePoints.addAll(locations.get(id));
            saePoints.add(saePoint);
            locations.put(id,saePoints);
        }else{
            saePoints.add(saePoint);
            locations.put(id, saePoints);
        }
    }

    public Hashtable<Integer, List<SaePoint>> getAllLocations(){
        return locations;
    }

    public SaePoint getLocation(int id, int index) {
        return locations.get(id).get(locations.get(id).size() - 1 - index);
    }

    public List<SaePoint> getLocations(int id) {
        return locations.get(id);
    }
}
