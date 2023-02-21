package ecommerce;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SellerServerFrontend {


    @PostMapping ("/createSellerAccount")
    public String createSellerAccount(@RequestBody JSONObject payload) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        ecommerce.SellerGrpc.SellerBlockingStub stub = ecommerce.SellerGrpc.newBlockingStub(channel);

        createSellerAccountResponse accountResponse = stub.createSellerAccount(createSellerAccountRequest.newBuilder()
                .setUsername((String)payload.get("userName"))
                .setPassword((String)payload.get("password"))
                .build());
        channel.shutdown();
        return accountResponse.getCreateAccountStatus();
    }

    @GetMapping("/sellerRating/{sellerId}")
    public String getRating(@PathVariable("sellerId") String sellerId) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        ecommerce.SellerGrpc.SellerBlockingStub stub = ecommerce.SellerGrpc.newBlockingStub(channel);
//        TimeUnit.SECONDS.sleep(4);
        sellerRatingResponse ratingResponse = stub.sellerRating(sellerRatingRequest.newBuilder()
                .setSellerId(Long.parseLong((String) sellerId))
                .build());
        channel.shutdown();
        return ratingResponse.getRatingStatus();
    }

    @DeleteMapping ("/removeItem")
    public String removeItem(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        ecommerce.SellerGrpc.SellerBlockingStub stub = ecommerce.SellerGrpc.newBlockingStub(channel);
//        TimeUnit.SECONDS.sleep(4);
        removeItemResponse removeItemResponse = stub.removeItem(removeItemRequest.newBuilder()
                .setItemId(Long.parseLong((String) payload.get("itemId")))
                .setQuantity(Integer.parseInt((String) payload.get("quantity")))
                .build());

        channel.shutdown();
        return removeItemResponse.getRemoveItemStatus();
    }

    @GetMapping ("/displayItemsOnSale/{sellerId}")
    public String displayItemsOnSale(@PathVariable("sellerId") String sellerId){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        ecommerce.SellerGrpc.SellerBlockingStub stub = ecommerce.SellerGrpc.newBlockingStub(channel);
//        TimeUnit.SECONDS.sleep(4);
        displayItemsOnSaleResponse displayItemsOnSaleResponse = stub.displayItemsOnSale(displayItemsOnSaleRequest.newBuilder()
                .setSellerId(Long.parseLong((String) sellerId))
                .build());
        channel.shutdown();
        return displayItemsOnSaleResponse.getDisplayItemsOnSaleStatus();
    }

    @PostMapping("/login")
    public String login(@RequestBody JSONObject payload){
//        System.out.println(payload);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        ecommerce.SellerGrpc.SellerBlockingStub stub = ecommerce.SellerGrpc.newBlockingStub(channel);
//        TimeUnit.SECONDS.sleep(4);
        ecommerce.sellerLoginResponse loginResponse = stub.sellerLogin(ecommerce.sellerLoginRequest.newBuilder()
                .setUsername((String) payload.get("name"))
                .setPassword((String) payload.get("password"))
                .build());
        channel.shutdown();
        return loginResponse.getLoginStatus();
    }


    @PostMapping("/logout")
    public String logout(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        ecommerce.SellerGrpc.SellerBlockingStub stub = ecommerce.SellerGrpc.newBlockingStub(channel);
//        TimeUnit.SECONDS.sleep(4);
        logoutSellerResponse logoutResponse = stub.logoutSeller(logoutSellerRequest.newBuilder()
                .setSellerId(Long.parseLong((String) payload.get("sellerId")))
                .build());
        channel.shutdown();
        return logoutResponse.getLogoutStatus();
    }

    @PostMapping("/putItem")
    public String putItem(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        ecommerce.SellerGrpc.SellerBlockingStub stub = ecommerce.SellerGrpc.newBlockingStub(channel);
//        TimeUnit.SECONDS.sleep(4);
        List<String> keywords = new ArrayList<>();
        keywords.add("headphones");
        keywords.add("wireless");
        keywords.add("music");
        keywords.add("sound");
        keywords.add("songs");
        putItemResponse putItemRes = stub.putItem(putItemRequest.newBuilder()
                .setItemName((String) payload.get("itemName"))
                .setItemCategory((Integer) payload.get("itemCategory"))
                .addAllKeywords(keywords)
                .setCondition((Boolean) payload.get("condition"))
                .setSalePrice((Double) payload.get("salePrice"))
                .setSellerId((Long) payload.get("sellerId"))
                .setQuantity((Integer) payload.get("quantity"))
                .build());
        channel.shutdown();
        return putItemRes.getPutItemStatus();
    }

    @PutMapping("/updateItemPrice")
    public String updateItemPrice(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081)
                .usePlaintext()
                .build();
        ecommerce.SellerGrpc.SellerBlockingStub stub = ecommerce.SellerGrpc.newBlockingStub(channel);
//        TimeUnit.SECONDS.sleep(4);
        updateItemSalePriceResponse updateItemSalePriceResponse = stub.updateItemSalePrice(updateItemSalePriceRequest.newBuilder()
                .setItemId(Long.parseLong((String) payload.get("itemId")))
                .setNewSalePrice(Double.parseDouble((String)payload.get("salePrice")))
                .build());
        channel.shutdown();
        return updateItemSalePriceResponse.getUpdateItemSalePriceStatus();
    }
}

