package at.ac.fhw.sae.lesson4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NmeaReaderApplication {

    private Scanner scanner;
    private final File file;
    private static final List<SaePoint> listOfAllPoints = new ArrayList<>();

    public NmeaReaderApplication(File nmeaFile){
        try {
            this.file = nmeaFile;
            assert nmeaFile.exists();
            FileInputStream fis = new FileInputStream(nmeaFile);
            scanner = new Scanner(fis);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = getScannedFile();

        while (scanner.hasNext()){
            String[] components = scanner.nextLine().split(",");
            if (components[0].equals("$GNGGA")) {

                double lat = calculateLat(components);

                double lon = calculateLon(components);

                //number of available Satelites
                int numberOfSatelites = Integer.parseInt(components[7]);

                //GPS fix
                int fix = Integer.parseInt(components[6]);

                //create object
                listOfAllPoints.add(new SaePoint(components[1],lat,lon,numberOfSatelites,fix));
            }
        }
        printTableOfPoints(listOfAllPoints);
    }

    /**
     * Creates new file object and file input stream
     * @return scanner
     * @throws FileNotFoundException
     */
    private static Scanner getScannedFile() throws FileNotFoundException {
        File file = new File(NmeaReaderApplication.class.getClassLoader().getResource("auto.txt").getFile());
        FileInputStream fis = new FileInputStream(file);
        Scanner scanner = new Scanner(fis);
        return scanner;
    }

    /**
     * Prints table with properties of points
     * @param listOfAllPoints list of all points
     */
    private static void printTableOfPoints(List<SaePoint> listOfAllPoints) {
        System.out.printf("| %-10s | %-20s | %-20s | %-7s | %-5s %n", "time", "latitude", "longitude", "satNr", "fix");
        System.out.println("---------------------------------------------------------------------------");
        for (SaePoint saePoint : listOfAllPoints) {
            System.out.printf("| %-10s | %-20s | %-20s | %-7s | %-5s %n", saePoint.getTime(), saePoint.getLatitude(), saePoint.getLongitude(), saePoint.getNumberOfSatelites(), saePoint.getFix());
        }
    }

    /**
     * Calculates longitude in degrees from GGA dataset
     * @param components string array from GNGGA lines
     * @return longitude in degrees
     */
    private static double calculateLon(String[] components) {
        String lonNmea = components[4];
        double lonNmeaDegDouble = Double.parseDouble(lonNmea.substring(0,3));
        double lonNmeaMinDouble = Double.parseDouble(lonNmea.substring(3));
        double lon = lonNmeaDegDouble + (lonNmeaMinDouble / 60);
        if (components[5].equals("W")){
            lon = lon * (-1);
        }
        return lon;
    }

    /**
     * Calculates latitude in degrees from GGA dataset
     * @param components string array from GNGGA lines
     * @return latitude in degrees
     */
    private static double calculateLat(String[] components) {
        String latNmea = components[2];
        double latNmeaDegDouble = Double.parseDouble(latNmea.substring(0,2));
        double latNmeaMinDouble = Double.parseDouble(latNmea.substring(2));
        double lat = latNmeaDegDouble + (latNmeaMinDouble / 60);
        if (components[3].equals("S")){
            lat = lat * (-1);
        }
        return lat;
    }

    public SaePoint readPoint() {
        SaePoint saePoint = null;

        while(saePoint == null && scanner.hasNext()) {
            String line = scanner.nextLine();
            if(line == null) {
                return null;
            }
            String[] components = line.split(",");

            if (components[0].equals(("$GNGGA"))) {
                String time = components[1];
                double latitude = Double.parseDouble(components[2].substring(0,2)) + Double.parseDouble(components[2].substring(2))/60;
                double longitude = Double.parseDouble(components[4].substring(0,3)) + Double.parseDouble(components[4].substring(3))/60;
                int fix = Integer.parseInt(components[6]);
                int nrOfSatelites = Integer.parseInt(components[7]);
                return new SaePoint(time,latitude,longitude,nrOfSatelites,fix);
            }
        }
        if (!scanner.hasNextLine()){
            assert file.exists();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);

            scanner = new Scanner(fis);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            return this.readPoint();

        }
        return null;
    }
}
