package at.ac.fhw.sae.lesson4;


public class SaePoint {

    private String time;
    private double latitude;
    private double longitude;
    private int numberOfSatelites;
    private int fix;

    public SaePoint() {
    }
    public SaePoint(String time, double latitude, double longitude, int numberOfSatelites, int fix){
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this. numberOfSatelites = numberOfSatelites;
        this.fix = fix;
    }

    public String getTime() {
        return time;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getFix() {
        return fix;
    }

    public int getNumberOfSatelites() {
        return numberOfSatelites;
    }

    public String formatToString() {
        return String.format("| %-10s | %-20s | %-20s | %-7s | %-5s %n", time, latitude, longitude , numberOfSatelites, fix);
    }
}

