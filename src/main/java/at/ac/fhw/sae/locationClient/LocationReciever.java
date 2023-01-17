package at.ac.fhw.sae.locationClient;

import at.ac.fhw.sae.lesson4.SaePoint;

import java.io.IOException;
import java.util.*;

public class LocationReciever {

    public static void main(String[] args) throws IOException {

        LocationClientService locationClientService = new LocationClientService();
        Scanner scanner = new Scanner(System.in);
        boolean end = false;

        while (!end){

            printHead();
            int selection = scanner.nextInt();

            switch (selection) {
                case 1 -> {
                    System.out.println("Bitte geben Sie die gewünschte id ein: ");
                    SaePoint saePoint = locationClientService.getLocation(scanner.nextInt());
                    List<SaePoint> listOfPointsLocation = new ArrayList<>();
                    listOfPointsLocation.add(saePoint);
                    printTableOfPoints(listOfPointsLocation);
                }
                case 2 -> {
                    System.out.println("Bitte geben Sie die gewünschte id ein: ");
                    List<SaePoint> listOfPointsLocations = locationClientService.getLocations(scanner.nextInt());
                    printTableOfPoints(listOfPointsLocations);
                }
                case 3 -> {
                    Hashtable<Integer, List<SaePoint>> allLocations = locationClientService.getAllLocations();
                    Set<Integer> keys = allLocations.keySet();
                    System.out.printf("ID  " +"| %-10s | %-20s | %-20s | %-7s | %-5s %n", "time", "latitude", "longitude", "satNr", "fix");
                    for (int key : keys) {
                        for (int i = 0; i < allLocations.get(key).size(); i++) {
                            System.out.println(key + "   " + allLocations.get(key).get(i).formatToString());
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Das Programm wird jetzt beendet");
                    end = true;
                }
                default -> System.out.println("Ungültige Eingabe - Geben Sie eine Zahl zwischen 1 und 4 ein!");
            }
        }



    }

    private static void printHead() {
        System.out.println("");
        System.out.println("--------Location Reciever--------");
        System.out.println(
                """
                        1. Letzte Poisition per id
                        2. Alle Position per id
                        3. Alle Positionen anzeigen
                        4. Programm beenden
                        """);
    }

    private static void printTableOfPoints(List<SaePoint> listOfAllPoints) {
        System.out.printf("| %-10s | %-20s | %-20s | %-7s | %-5s %n", "time", "latitude", "longitude", "satNr", "fix");
        System.out.println("---------------------------------------------------------------------------");
        for (SaePoint saePoint : listOfAllPoints) {
            System.out.printf("| %-10s | %-20s | %-20s | %-7s | %-5s %n", saePoint.getTime(), saePoint.getLatitude(), saePoint.getLongitude(), saePoint.getNumberOfSatelites(), saePoint.getFix());
        }
    }
}
