package com.example.demo;


import java.io.*;
import java.net.Socket;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class SellerClient {
    private PrintWriter out;
    private BufferedReader in;


        static public void createAccount(HttpClient client, String payload) throws IOException, InterruptedException{
            URI createUser = URI.create("http://localhost:8080/createUser");
            HttpRequest httpPostRequest = HttpRequest.newBuilder()
                                                .uri(createUser)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a string payload"))
                                                .build();
            HttpResponse<String> postResponse = client.send(httpPostRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(postResponse.body());
        }

        static public void login(HttpClient client, String payload) throws IOException, InterruptedException{
            URI login = URI.create("http://localhost:8080/login");
            HttpRequest httpLoginRequest = HttpRequest.newBuilder()
                                                .uri(login)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a login payload"))
                                                .build();
            HttpResponse<String> loginResponse = client.send(httpLoginRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(loginResponse.body());
        }

        static public void logout(HttpClient client, String payload) throws IOException, InterruptedException{
            URI logout = URI.create("http://localhost:8080/logout");
            HttpRequest httpLogoutRequest = HttpRequest.newBuilder()
                                                .uri(logout)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a logout payload"))
                                                .build();
            HttpResponse<String> logoutResponse = client.send(httpLogoutRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(logoutResponse.body());
        }

        static public void rating(HttpClient client, String payload) throws IOException, InterruptedException{
            String[] parts = payload.split(" ");
            URI ratingUri = URI.create("http://localhost:8080/rating/"+parts[1]);
            HttpRequest requestSellerRating = HttpRequest.newBuilder().uri(ratingUri).GET().build();
            HttpResponse<String> response = client.send(requestSellerRating, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        }

        static public void putItem(HttpClient client, String payload) throws IOException, InterruptedException{
            URI putItem = URI.create("http://localhost:8080/putItem");
            HttpRequest httpPutItemRequest = HttpRequest.newBuilder()
                                                .uri(putItem)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a putItem payload"))
                                                .build();
            HttpResponse<String> putItemResponse = client.send(httpPutItemRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(putItemResponse.body());
        }

        static public void updateItem(HttpClient client, String payload) throws IOException, InterruptedException{
            URI updateItemPrice = URI.create("http://localhost:8080/update");
            HttpRequest httpUpdateRequest = HttpRequest.newBuilder()
                                                .uri(updateItemPrice)
                                                .header("Content-Type", "text/plain")
                                                .PUT(HttpRequest.BodyPublishers.ofString("This is a update payload"))
                                                .build();
            HttpResponse<String> updateResponse = client.send(httpUpdateRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(updateResponse.body());

        }
    


        public static void main(String[] args) throws IOException, InterruptedException{
            HttpClient client = HttpClient.newHttpClient();

            
            
            
            
            
           
            File file = new File("D:\\Gautam\\java\\Dist\\demo\\demo\\src\\main\\resources\\file1.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                // System.out.println(st+);
                String[] parts = st.split(" ");
                String part1 = parts[0];
                // String part2 = parts[1];
                // String part3 = String.join(" ",Arrays.copyOfRange(parts,2,parts.length));
                // System.out.println("------------------------------");
                // System.out.println("Part1 = "+part1);
                // System.out.println("Part2 = "+part2);
                // System.out.println("Part3 = "+part3);

                if(part1.equals("1")){
                    createAccount(client, st);
                }
                if(part1.equals("2")){
                    login(client, st);
                }
                if(part1.equals("3")){
                    logout(client, st);
                }
                if(part1.equals("4")){
                    rating(client, st);
                }
                if(part1.equals("5")){
                    putItem(client, st);
                }
                if(part1.equals("6")){
                    updateItem(client, st);
                }

                // System.out.println(st + st.charAt(0));
            }

    }
}
