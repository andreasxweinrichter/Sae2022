package at.ac.fhw.sae.locationClient;

import at.ac.fhw.sae.lesson4.NmeaReaderApplication;
import at.ac.fhw.sae.lesson4.SaePoint;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class LocationTransmitter {
    private static final int id = 1;

    public static void main(String[] args) {

        File file = new File(NmeaReaderApplication.class.getClassLoader().getResource("auto.txt").getFile());

        NmeaReaderApplication nmeaReader = new NmeaReaderApplication(file);

        LocationClientService clientService = new LocationClientService();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                SaePoint saePoint = nmeaReader.readPoint();
                System.out.println("Time: "+ new Date());
                clientService.sendLocation(saePoint, id);
            }
        };

        Timer timer = new Timer("timerTask");

        timer.scheduleAtFixedRate(timerTask,1000, 1000);

    }
}

