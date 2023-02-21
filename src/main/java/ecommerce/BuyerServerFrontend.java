package ecommerce;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONObject;

@RestController
public class BuyerServerFrontend {

    @PostMapping("/createBuyerAccount")
    public String createBuyerAccount(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
//        TimeUnit.SECONDS.sleep(4);
        createBuyerAccountResponse createBuyerAccountResponse = stub.createBuyerAccount(createBuyerAccountRequest.newBuilder()
                .setUsername(((String) payload.get("userName")))
                .setPassword(((String) payload.get("password")))
                .build());
        channel.shutdown();
        return createBuyerAccountResponse.getCreateAccountStatus();
    }

    @PostMapping("/loginBuyer")
    public String loginBuyer(@RequestBody JSONObject payload){
//        System.out.println(payload);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
//        TimeUnit.SECONDS.sleep(4);
        loginBuyerResponse loginResponse = stub.loginBuyer(loginBuyerRequest.newBuilder()
                .setBuyerId(Long.parseLong((String) payload.get("buyerId")))
                        .setPassword((String) payload.get("password"))
                .build());
        channel.shutdown();
        return loginResponse.getLoginStatus();
    }

    @PostMapping("/logoutBuyer")
    public String logoutBuyer(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
        logoutBuyerResponse logoutResponse = stub.logoutBuyer(logoutBuyerRequest.newBuilder()
                .setBuyerId(Long.parseLong((String) payload.get("buyerId")))
                .build());
        channel.shutdown();
        return logoutResponse.getLogoutStatus();
    }


    @PostMapping("/addToShoppingCart")
    public String addToShoppingCart(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
//
        addToShoppingCartResponse addToShoppingCartResponse = stub.addToShoppingCart(addToShoppingCartRequest.newBuilder()
                .setBuyerId(Long.parseLong((String) payload.get("buyerId")))
                .setItemId(Long.parseLong((String) payload.get("itemId")))
                .setQuantity(Integer.parseInt((String) payload.get("quantity")))
                .build());
        channel.shutdown();
        return addToShoppingCartResponse.getAddToShoppingCartStatus();
    }

    @PutMapping("/removeItemFromShoppingCart")
    public String removeFromShoppingCart(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
//
        removeFromShoppingCartResponse removeFromShoppingCartResponse = stub.removeFromShoppingCart(removeFromShoppingCartRequest.newBuilder()
                .setBuyerId(Long.parseLong((String) payload.get("buyerId")))
                .setItemId(Long.parseLong((String) payload.get("itemId")))
                .setQuantity(Integer.parseInt((String) payload.get("quantity")))
                .build());
        channel.shutdown();
        return removeFromShoppingCartResponse.getRemoveFromShoppingCartStatus();
    }

    @DeleteMapping("/clearShoppingCart")
    public String clearShoppingCart(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
//
        clearShoppingCartResponse clearShoppingCartResponse = stub.clearShoppingCart(clearShoppingCartRequest.newBuilder()
                .setBuyerId(Long.parseLong((String) payload.get("buyerId")))
                .build());
        channel.shutdown();
        return clearShoppingCartResponse.getClearShoppingCartStatus();
    }

    @GetMapping("/displayShoppingCart/{buyerId}")
    public String displayShoppingCart(@PathVariable("buyerId") String buyerId){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
//
        displayShoppingCartResponse displayShoppingCartResponse = stub.displayShoppingCart(displayShoppingCartRequest.newBuilder()
                .setBuyerId(Long.parseLong((String) buyerId))
                .build());
        channel.shutdown();
        return displayShoppingCartResponse.getDisplayShoppingCartStatus();
    }

    @PostMapping("/feedbackSeller")
    public String feedBackSeller(@RequestBody JSONObject payload){

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
//
        feedBackSellerResponse feedBackSellerResponse = stub.feedBackSeller(feedBackSellerRequest.newBuilder()
                .setItemId(Long.parseLong((String) payload.get("itemId")))
                .setRating(Integer.parseInt((String) payload.get("rating")))
                .build());
        channel.shutdown();
        return feedBackSellerResponse.getFeedBackSellerStatus();
    }

    @GetMapping("/sellerRatingByBuyer/{sellerId}")
    public String sellerRating(@PathVariable("sellerId") String sellerId){

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
//
        sellerRatingByBuyerResponse sellerRatingByBuyerResponse = stub.sellerRating(sellerRatingByBuyerRequest.newBuilder()
                .setSellerId(Long.parseLong((String) sellerId))
                .build());
        channel.shutdown();
        return sellerRatingByBuyerResponse.getRatingStatus();
    }

//    @PostMapping("/searchItems")
//    public String searchItems(@RequestBody JSONObject payload){
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
//                .usePlaintext()
//                .build();
//        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
////
//        searchItemsResponse searchItemsResponse = stub.searchItems(searchItemsRequest.newBuilder()
//                .setItemCategory(Integer.parseInt((String) payload.get("itemCategory")))
//                        .setKeywords()
//
//                .build());
//        channel.shutdown();
//        return searchItemsResponse.getSearchItemsStatus();
//    }

    @GetMapping("/purchaseHistory/{buyerId}")
    public String purchaseHistory(@PathVariable("buyerId") String buyerId){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);
//
        purchaseHistoryResponse purchaseHistoryResponse = stub.purchaseHistory(purchaseHistoryRequest.newBuilder()
                .setBuyerId(Long.parseLong((String) buyerId))
                .build());
        channel.shutdown();
        return purchaseHistoryResponse.getPurchaseHistoryStatus();
    }

    @PostMapping ("/makePurchase")
    public String makePurchase(@RequestBody JSONObject payload){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8092)
                .usePlaintext()
                .build();
        BuyerGrpc.BuyerBlockingStub stub = ecommerce.BuyerGrpc.newBlockingStub(channel);

        makePurchaseResponse makePurchaseResponse = stub.makePurchase(makePurchaseRequest.newBuilder()
                .setBuyerId(Long.parseLong((String) payload.get("buyerId")))
                .setBuyerName((String) payload.get("buyerName"))
                .setCardNumber((String) payload.get("cardNumber"))
                .setExpiryDate((String) payload.get("expiryDate"))
                .build());
        channel.shutdown();
        return makePurchaseResponse.getMakePurchaseStatus();
    }

}

