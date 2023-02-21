package ecommerce;


import org.json.simple.JSONArray;
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

public class BuyerClient {
    private PrintWriter out;
    private BufferedReader in;


        static public void createBuyerAccount(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/createBuyerAccount","POST");
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

    static public void loginBuyer(String url, String payload) throws IOException, InterruptedException{
        HttpURLConnection con = establishConnection(url,"/loginBuyer","POST");
        String[] components = payload.split(" ");
        JSONObject obj = new JSONObject();
        obj.put("buyerId", components[1]);
        obj.put("password", components[2]);
        String jsonInputString = obj
                .toString();
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        printResponse(con);

    }
 

        static public void logoutBuyer(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/logoutBuyer","POST");
            String[] components = payload.split(" ");
            JSONObject obj = new JSONObject();
            obj.put("buyerId", components[1]);
            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);
        }

        static public void addToShoppingCart(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/addToShoppingCart","POST");
            String[] components = payload.split(" ");
            JSONObject obj = new JSONObject();
            obj.put("buyerId", components[1]);
            obj.put("itemId", components[2]);
            obj.put("quantity", components[3]);
            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);
        }

        static public void removeFromShoppingCart(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/removeItemFromShoppingCart","POST");
            String[] components = payload.split(" ");
            JSONObject obj = new JSONObject();
            obj.put("buyerId", components[1]);
            obj.put("itemId", components[2]);
            obj.put("quantity", components[3]);
            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);
        }

        static public void clearShoppingCart(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/clearShoppingCart","POST");
            String[] components = payload.split(" ");
            JSONObject obj = new JSONObject();
            obj.put("buyerId", components[1]);
            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);

        }

        static public void displayShoppingCart(String url, String payload) throws IOException, InterruptedException{
            String[] components = payload.split(" ");
            HttpURLConnection con = establishConnection(url,"/displayShoppingCart/"+components[1],"GET");
            printResponse(con);
        }

        static public void feedBackSeller(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/feedbackSeller","POST");
            String[] components = payload.split(" ");
            JSONObject obj = new JSONObject();
            obj.put("itemId", components[1]);
            obj.put("rating", components[2]);
            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);
        }

        static public void sellerRating(String url, String payload) throws IOException, InterruptedException{
            String[] components = payload.split(" ");
            HttpURLConnection con = establishConnection(url,"/sellerRatingByBuyer/"+components[1],"GET");
            printResponse(con);

        }

        static public void searchItems(String url, String payload) throws IOException, InterruptedException{
            HttpURLConnection con = establishConnection(url,"/searchItems","POST");
            String[] components = payload.split(" ");
            JSONArray Keywords = new JSONArray();
            Keywords.add(components[2]);
            Keywords.add(components[3]);
            Keywords.add(components[4]);
            Keywords.add(components[5]);
            Keywords.add(components[6]);
            JSONObject obj = new JSONObject();
            obj.put("itemCategory", components[1]);
            obj.put("keywords",Keywords);

            String jsonInputString = obj
                    .toString();
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            printResponse(con);
        }
        
        static public void purchaseHistory(String url, String payload) throws IOException, InterruptedException{
            String[] components = payload.split(" ");
            HttpURLConnection con = establishConnection(url,"/purchaseHistory/"+components[1],"GET");
            printResponse(con);
        }

    static public void makePurchase(String url, String payload) throws IOException, InterruptedException{
        HttpURLConnection con = establishConnection(url,"/makePurchase","POST");
        String[] components = payload.split(" ");
        JSONObject obj = new JSONObject();
        obj.put("buyerId", components[1]);
        obj.put("buyerName", components[2]);
        obj.put("cardNumber", components[1]);
        obj.put("expiryDate", components[2]);
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
            final long startTime = System.currentTimeMillis();
            File file = new File(args[0]);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            String ip_address = args[1];
            String portNum = args[2];
            while ((st = br.readLine()) != null) {
                // System.out.println(st+);
                String[] parts = st.split(" ");
                String part1 = parts[0];

                if(part1.equals("1")){
                    createBuyerAccount(ip_address+portNum, st);
                }
                if(part1.equals("2")){
                    loginBuyer(ip_address+portNum, st);
                }
                if(part1.equals("3")){
                    logoutBuyer(ip_address+portNum, st);
                }
                if(part1.equals("4")){
                    addToShoppingCart(ip_address+portNum, st);
                }
                if(part1.equals("5")){
                    removeFromShoppingCart(ip_address+portNum, st);
                }
                if(part1.equals("6")){
                    clearShoppingCart(ip_address+portNum, st);
                }
                if(part1.equals("7")){
                    displayShoppingCart(ip_address+portNum, st);
                }
                if(part1.equals("8")){
                    feedBackSeller(ip_address+portNum, st);
                }
                if(part1.equals("9")){
                    sellerRating(ip_address+portNum, st);
                }
                if(part1.equals("10")){
                    searchItems(ip_address+portNum, st);
                }
                if(part1.equals("11")){
                    purchaseHistory(ip_address+portNum, st);
                }
                if(part1.equals("12")){
                    makePurchase(ip_address+portNum, st);
                }

                // System.out.println(st + st.charAt(0));
            }
            final long endTime = System.currentTimeMillis();
            System.out.println("Buyer client execution time: " + (endTime - startTime));
            String finalMessage = "Buyer Server start time: " + startTime + " end time: " + endTime;
            System.out.println(finalMessage);
            String filename = String.valueOf(startTime)+"_buyer"+"_"+String.valueOf(args[3]);
            try {
                FileWriter myWriter = new FileWriter(filename);
                myWriter.write(finalMessage + "\n" + "Buyer client execution time: " + (endTime - startTime));
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }
}
