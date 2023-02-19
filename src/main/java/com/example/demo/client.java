package com.example.demo;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class client  {   
    public static void main(String[] args) throws IOException, InterruptedException{
        // Create a new HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Define the URI of the REST API endpoint
        URI uri = URI.create("http://localhost:8080/1/Gautam/Gautam123");

        // create a new HttpRequest with the GET method
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

        // send the httprequest and get the httpresponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // print the response body
        System.out.println(response.body());
    }
    
}
