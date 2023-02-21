package ecommerce;


import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class SellerClient {
    private PrintWriter out;
    private BufferedReader in;


        static public void createAccount(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/createSellerAccount","POST");
            String[] components = payload.split(" ");
            JSONObject obj = new JSONObject();
            obj.put("userName", components[1]);
            obj.put("password", components[2]);
            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);
        }
    static public void removeItem(String url, String payload) throws IOException, InterruptedException{
        HttpURLConnection con = establishConnection(url,"/removeItem","DELETE");
        String[] components = payload.split(" ");
        JSONObject obj = new JSONObject();
        obj.put("itemId", components[1]);
        obj.put("quantity", components[2]);
        String jsonInputString = obj
                .toString();
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        printResponse(con);
    }

    static public void displayItemsOnSale(String url, String payload) throws IOException, InterruptedException{
        String[] components = payload.split(" ");
        HttpURLConnection con = establishConnection(url,"/displayItemsOnSale/"+components[1],"GET");
        printResponse(con);

    }


    static public HttpURLConnection establishConnection(String url,String endpoint,String RequestMethod) throws IOException {
        URL lol = new URL (url+endpoint);
        HttpURLConnection con = (HttpURLConnection)lol.openConnection();
        con.setRequestMethod(RequestMethod);
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        return con;
    }
    static public void printResponse(HttpURLConnection con) throws IOException {
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
    static public void login(String url, String payload) throws IOException, InterruptedException{
        HttpURLConnection con = establishConnection(url,"/login","POST");
        String[] components = payload.split(" ");
        JSONObject obj = new JSONObject();
        obj.put("name", components[1]);
        obj.put("password", components[2]);
        String jsonInputString = obj
                .toString();
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        printResponse(con);

    }

        static public void logout(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/logout","POST");
            String[] components = payload.split(" ");
            JSONObject obj = new JSONObject();
            obj.put("sellerId", components[1]);
            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);
        }

        static public void rating(String url, String payload) throws IOException, InterruptedException{
            String[] components = payload.split(" ");
            HttpURLConnection con = establishConnection(url,"/sellerRating/"+components[1],"GET");
            printResponse(con);

        }

        static public void putItem(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/login","POST");
            String[] components = payload.split(" ");
            JSONObject obj = new JSONObject();
            obj.put("name", components[1]);
            obj.put("password", components[2]);
            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);
        }

        static public void updateItem(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/updateItemPrice","PUT");
            String[] components = payload.split(" ");
            JSONObject obj = new JSONObject();
            obj.put("itemId", components[1]);
            obj.put("salePrice", components[2]);
            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);

        }
    


        public static void main(String[] args) throws IOException, InterruptedException{
            HttpClient client = HttpClient.newHttpClient();
            String ip_address = "http://localhost:";
            String portNum = "8080";
           
            File file = new File("src/main/resources/file1.txt");
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
                    createAccount(ip_address+portNum, st);
                }
                if(part1.equals("2")){
                    login(ip_address+portNum, st);
                }
                if(part1.equals("3")){
                    logout(ip_address+portNum, st);
                }
                if(part1.equals("4")){
                    rating(ip_address+portNum, st);
                }
//                if(part1.equals("5")){
//                    putItem(ip_address+portNum, st);
//                }
                if(part1.equals("6")){
                    updateItem(ip_address+portNum, st);
                }
                else if(part1.equals("7")) {
                    removeItem(ip_address+portNum, st);
                }
                else if(part1.equals("8")) {
                    displayItemsOnSale(ip_address+portNum, st);
                }

                // System.out.println(st + st.charAt(0));
            }

    }
}
