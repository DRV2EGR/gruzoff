package ru.gruzoff.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Geocoder {
    @Value("${geocoding.api.key}")
    private String API_KEY;

    private static final String GEOCODING_ADDRESS = "https://geocoder.ls.hereapi.com/6.2/geocode.json";
    private static final String GEOCODING_CALCULATE_ROUTE = "https://route.ls.hereapi.com/routing/7.2/calculateroute.json";

    public List<Float> GeocodeSync(String query) throws Exception {
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String requestUri = GEOCODING_ADDRESS + "?apiKey=" + API_KEY + "&searchtext=" + encodedQuery;
        URL url = new URL(requestUri);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        Reader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();

        //System.out.println(response);
        JSONObject myResponse = new JSONObject(response.toString());

        //System.out.println("result after Reading JSON Response");
        //System.out.println("Response- "+myResponse.getJSONObject("Response").getJSONObject("MetaInfo").getString("Timestamp"));

        return List.of(
                myResponse.getJSONObject("Response")
                .getJSONArray("View").getJSONObject(0)
                .getJSONArray("Result").getJSONObject(0)
                .getJSONObject("Location")
                .getJSONArray("NavigationPosition").getJSONObject(0)
                .getFloat("Latitude"),
                myResponse.getJSONObject("Response")
                        .getJSONArray("View").getJSONObject(0)
                        .getJSONArray("Result").getJSONObject(0)
                        .getJSONObject("Location")
                        .getJSONArray("NavigationPosition").getJSONObject(0)
                        .getFloat("Longitude")
        );
    }

    public float GeocodeRoute(float lat0, float lon0, float lat1, float lon1) throws IOException {
        String waypoint0 = URLEncoder.encode("geo!"+String.valueOf(lat0)+","+String.valueOf(lon0), StandardCharsets.UTF_8);
        String waypoint1 = URLEncoder.encode("geo!"+String.valueOf(lat1)+","+String.valueOf(lon1), StandardCharsets.UTF_8);

        String requestUri = GEOCODING_CALCULATE_ROUTE + "?apiKey=" + API_KEY + "&waypoint0=" + waypoint0 + "&waypoint1=" + waypoint1 + "&mode=fastest;car;traffic:disabled";
        URL url = new URL(requestUri);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        Reader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (int c; (c = in.read()) >= 0;)
            sb.append((char)c);
        String response = sb.toString();

        //System.out.println(response);
        JSONObject myResponse = new JSONObject(response.toString());

        //System.out.println("result after Reading JSON Response");
        //System.out.println("Response- "+myResponse.getJSONObject("Response").getJSONObject("MetaInfo").getString("Timestamp"));

        return myResponse.getJSONObject("response")
                .getJSONArray("route").getJSONObject(0)
                .getJSONObject("summary")
                .getFloat("travelTime");
    }

}
