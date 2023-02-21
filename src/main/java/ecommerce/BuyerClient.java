package ecommerce;


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


        static public void createBuyerAccount(HttpClient client, String payload) throws IOException, InterruptedException{
            URI createUser = URI.create("http://localhost:8080/buyer/createUser");
            HttpRequest httpPostRequest = HttpRequest.newBuilder()
                                                .uri(createUser)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a string payload"))
                                                .build();
            HttpResponse<String> postResponse = client.send(httpPostRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(postResponse.body());
        }

//        static public void login(HttpClient client, String payload) throws IOException, InterruptedException{
//            URI login = URI.create("http://localhost:8080/login");
//            HttpRequest httpLoginRequest = HttpRequest.newBuilder()
//                                                .uri(login)
//                                                .header("Content-Type", "text/plain")
//                                                .POST(HttpRequest.BodyPublishers.ofString("This is a login payload"))
//                                                .build();
//            HttpResponse<String> loginResponse = client.send(httpLoginRequest, HttpResponse.BodyHandlers.ofString());
//            System.out.println(loginResponse.body());
//        }

    static public void loginBuyer(HttpClient client, String payload) throws IOException, InterruptedException{
        URL url = new URL ("http://localhost:8080/buyer/login");
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);
        String jsonInputString = "{\"name\": \"Upendra\", \"password\": \"Programmer\"}";
        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
//        HttpRequest httpLoginRequest = HttpRequest.newBuilder()
//                .uri(login)
//                .header("Content-Type", "text/plain")
//                .POST(HttpRequest.BodyPublishers.ofString("This is a login payload"))
//                .build();
//        HttpResponse<String> loginResponse = client.send(httpLoginRequest, HttpResponse.BodyHandlers.ofString());
//        System.out.println(loginResponse.body());
    }

        static public void logoutBuyer(HttpClient client, String payload) throws IOException, InterruptedException{
            URI logout = URI.create("http://localhost:8080/buyer/logout");
            HttpRequest httpLogoutRequest = HttpRequest.newBuilder()
                                                .uri(logout)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a logout payload"))
                                                .build();
            HttpResponse<String> logoutResponse = client.send(httpLogoutRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(logoutResponse.body());
        }

        static public void addToShoppingCart(HttpClient client, String payload) throws IOException, InterruptedException{
            String[] parts = payload.split(" ");
            URI ratingUri = URI.create("http://localhost:8080//addToCart");
            HttpRequest requestSellerRating = HttpRequest.newBuilder().uri(ratingUri).GET().build();
            HttpResponse<String> response = client.send(requestSellerRating, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        }

        static public void removeFromShoppingCart(HttpClient client, String payload) throws IOException, InterruptedException{
            URI putItem = URI.create("http://localhost:8080/removeItem");
            HttpRequest httpPutItemRequest = HttpRequest.newBuilder()
                                                .uri(putItem)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a putItem payload"))
                                                .build();
            HttpResponse<String> putItemResponse = client.send(httpPutItemRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(putItemResponse.body());
        }

        static public void clearShoppingCart(HttpClient client, String payload) throws IOException, InterruptedException{
            URI updateItemPrice = URI.create("http://localhost:8080/clearCart");
            HttpRequest httpUpdateRequest = HttpRequest.newBuilder()
                                                .uri(updateItemPrice)
                                                .header("Content-Type", "text/plain")
                                                .PUT(HttpRequest.BodyPublishers.ofString("This is a update payload"))
                                                .build();
            HttpResponse<String> updateResponse = client.send(httpUpdateRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(updateResponse.body());

        }

        static public void displayShoppingCart(HttpClient client, String payload) throws IOException, InterruptedException{
            String[] parts = payload.split(" ");
            URI ratingUri = URI.create("http://localhost:8080/display");
            HttpRequest requestSellerRating = HttpRequest.newBuilder().uri(ratingUri).GET().build();
            HttpResponse<String> response = client.send(requestSellerRating, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        }

        static public void feedBackSeller(HttpClient client, String payload) throws IOException, InterruptedException{
            String[] parts = payload.split(" ");
            URI ratingUri = URI.create("http://localhost:8080//feedback");
            HttpRequest requestSellerRating = HttpRequest.newBuilder().uri(ratingUri).GET().build();
            HttpResponse<String> response = client.send(requestSellerRating, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        }

        static public void sellerRating(HttpClient client, String payload) throws IOException, InterruptedException{
            String[] parts = payload.split(" ");
            URI ratingUri = URI.create("http://localhost:8080/sellerRating");
            HttpRequest requestSellerRating = HttpRequest.newBuilder().uri(ratingUri).GET().build();
            HttpResponse<String> response = client.send(requestSellerRating, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        }

        static public void searchItems(HttpClient client, String payload) throws IOException, InterruptedException{
            String[] parts = payload.split(" ");
            URI ratingUri = URI.create("http://localhost:8080/search");
            HttpRequest requestSellerRating = HttpRequest.newBuilder().uri(ratingUri).GET().build();
            HttpResponse<String> response = client.send(requestSellerRating, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        }
        
        static public void purchaseHistory(HttpClient client, String payload) throws IOException, InterruptedException{
            String[] parts = payload.split(" ");
            URI ratingUri = URI.create("http://localhost:8080/purchaseHistory");
            HttpRequest requestSellerRating = HttpRequest.newBuilder().uri(ratingUri).GET().build();
            HttpResponse<String> response = client.send(requestSellerRating, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        }


        

        public static void main(String[] args) throws IOException, InterruptedException{
            HttpClient client = HttpClient.newHttpClient();

           
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
                    createBuyerAccount(client, st);
                }
                if(part1.equals("2")){
                    loginBuyer(client, st);
                }
                if(part1.equals("3")){
                    logoutBuyer(client, st);
                }
                if(part1.equals("4")){
                    addToShoppingCart(client, st);
                }
                if(part1.equals("5")){
                    removeFromShoppingCart(client, st);
                }
                if(part1.equals("6")){
                    clearShoppingCart(client, st);
                }
                if(part1.equals("7")){
                    displayShoppingCart(client, st);
                }
                if(part1.equals("8")){
                    feedBackSeller(client, st);
                }
                if(part1.equals("9")){
                    sellerRating(client, st);
                }
                if(part1.equals("10")){
                    searchItems(client, st);
                }
                if(part1.equals("11")){
                    purchaseHistory(client, st);
                }

                // System.out.println(st + st.charAt(0));
            }

    }
}
