package ecommerce;
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
        URI ratingUri = URI.create("http://localhost:8080/rating/Gautam");

        URI createUser = URI.create("http://localhost:8080/createUser");

        URI login = URI.create("http://localhost:8080/login");

        URI logout = URI.create("http://localhost:8080/logout");

        URI putItem = URI.create("http://localhost:8080/putItem");

        URI updateItemPrice = URI.create("http://localhost:8080/update");

        // create a new HttpRequest with the GET method
        HttpRequest requestSellerRating = HttpRequest.newBuilder().uri(ratingUri).GET().build();

        HttpRequest httpPostRequest = HttpRequest.newBuilder()
                                                .uri(createUser)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a string payload"))
                                                .build();
        
        HttpRequest httpLoginRequest = HttpRequest.newBuilder()
                                                .uri(login)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a login payload"))
                                                .build();

        HttpRequest httpLogoutRequest = HttpRequest.newBuilder()
                                                .uri(logout)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a logout payload"))
                                                .build();

        HttpRequest httpPutItemRequest = HttpRequest.newBuilder()
                                                .uri(putItem)
                                                .header("Content-Type", "text/plain")
                                                .POST(HttpRequest.BodyPublishers.ofString("This is a putItem payload"))
                                                .build();

        HttpRequest httpUpdateRequest = HttpRequest.newBuilder()
                                                .uri(updateItemPrice)
                                                .header("Content-Type", "text/plain")
                                                .PUT(HttpRequest.BodyPublishers.ofString("This is a update payload"))
                                                .build();

        // send the httprequest and get the httpresponse
        HttpResponse<String> response = client.send(requestSellerRating, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> postResponse = client.send(httpPostRequest, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> loginResponse = client.send(httpLoginRequest, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> logoutResponse = client.send(httpLogoutRequest, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> putItemResponse = client.send(httpPutItemRequest, HttpResponse.BodyHandlers.ofString());

        HttpResponse<String> updateResponse = client.send(httpUpdateRequest, HttpResponse.BodyHandlers.ofString());

        // print the response body
        System.out.println(response.body());

        System.out.println(postResponse.body());

        System.out.println(loginResponse.body());

        System.out.println(logoutResponse.body());

        System.out.println(putItemResponse.body());

        System.out.println(updateResponse.body());
    }
    
}
