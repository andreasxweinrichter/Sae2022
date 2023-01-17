package at.ac.fhw.sae.locationServer;

import at.ac.fhw.sae.homework3.Cow;
import at.ac.fhw.sae.lesson4.SaePoint;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class CowService {

    Hashtable<Integer, Cow> cows = new Hashtable<>();

    public void helloWorld(Cow cow, int index){
        System.out.println("Hello World");

        cows.put(index, cow);
    }
    public Hashtable<Integer, Cow> getCows(){
        return cows;
    }

}

