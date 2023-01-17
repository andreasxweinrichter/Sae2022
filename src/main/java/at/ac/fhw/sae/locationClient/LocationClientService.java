package at.ac.fhw.sae.locationClient;

import at.ac.fhw.sae.lesson4.SaePoint;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class LocationClientService {

        private static final String REQUEST_METHOD_SET_LOCATION = "/setLocation";
        private static final String REQUEST_METHOD_GET_LOCATION = "/location";
        private static final String REQUEST_METHOD_GET_LOCATIONS = "/locations";
        private static final String REQUEST_METHOD_GET_ALL_LOCATIONS = "/allLocations";
        private static final String BASE_URL = "https://location-server-weinrichter-location-app-api.azuremicroservices.io";
        private static String jsonArray = null;

        public SaePoint sendLocation(SaePoint pointToSend, int id){
                String url = BASE_URL + REQUEST_METHOD_SET_LOCATION + "?id=" + id + "&lat=" + pointToSend.getLatitude() + "&lon=" + pointToSend.getLongitude() + "&time=" + pointToSend.getTime() + "&satNr=" + pointToSend.getNumberOfSatelites() + "&fixQ=" + pointToSend.getFix();
                HttpURLConnection connection = null;
                try {
                        connection = (HttpURLConnection) new URL(url).openConnection();
                        Scanner scanner = new Scanner(connection.getInputStream());
                        System.out.println(scanner.nextLine());
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
                return pointToSend;
        }

        public SaePoint getLocation(int id) throws JsonProcessingException {
                String url = BASE_URL + REQUEST_METHOD_GET_LOCATION + "?id=" + id;
                HttpURLConnection connection = null;
                try {
                        connection = (HttpURLConnection) new URL(url).openConnection();
                        String json = getResponseString(connection.getInputStream());
                        return new ObjectMapper().readValue(json, SaePoint.class);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }

        }

        public List<SaePoint> getLocations(int id) throws JsonProcessingException {
                String url = BASE_URL + REQUEST_METHOD_GET_LOCATIONS + "?id=" + id;
                HttpURLConnection connection = null;
                try {
                        connection = (HttpURLConnection) new URL(url).openConnection();
                        jsonArray = getResponseString(connection.getInputStream());
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
                return new ObjectMapper().readValue(jsonArray , new TypeReference<List<SaePoint>>(){});
        }

        public Hashtable<Integer,List<SaePoint>> getAllLocations() throws IOException {
                String url = BASE_URL + REQUEST_METHOD_GET_ALL_LOCATIONS;
                HttpURLConnection connection = null;
                jsonArray = null;
                try {
                        connection = (HttpURLConnection) new URL(url).openConnection();
                        jsonArray = getResponseString(connection.getInputStream());
                        return new ObjectMapper().readValue(jsonArray , new TypeReference <Hashtable<Integer,List<SaePoint>>>(){});
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }

        }

        private String getResponseString(InputStream inputStream) {
                Scanner scanner = new Scanner(inputStream);
                StringBuffer stringBuffer = new StringBuffer();
                while (scanner.hasNextLine()){
                        stringBuffer.append(scanner.nextLine());
                }
                return stringBuffer.toString();
        }
}


