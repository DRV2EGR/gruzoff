package ru.gruzoff;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gruzoff.service.Geocoder;

@SpringBootApplication
public class GruzoffApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
//        ObjectMapper mapper = new ObjectMapper();
//        Geocoder geocoder = new Geocoder();
//
//        String response = geocoder.GeocodeSync("11 Wall St, New York, NY 10005");
//        JsonNode responseJsonNode = mapper.readTree(response);
//
//        JsonNode items = responseJsonNode.get("items");
//
//        for (JsonNode item : items) {
//            JsonNode address = item.get("address");
//            String label = address.get("label").asText();
//            JsonNode position = item.get("position");
//
//            String lat = position.get("lat").asText();
//            String lng = position.get("lng").asText();
//            System.out.println(label + " is located at " + lat + "," + lng + ".");
//        }

        SpringApplication.run(GruzoffApplication.class, args);
    }

}
