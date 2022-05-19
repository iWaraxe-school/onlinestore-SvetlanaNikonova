package com.issoft.store.httpServer.handler;

import com.issoft.domain.Product;
import com.issoft.store.Store;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
//import io.restassured.mapper.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CartHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        InputStream requestBody = exchange.getRequestBody();
        ObjectMapper mapper = new ObjectMapper();
        Product product = mapper.readValue(requestBody, Product.class);
        Store store = Store.getStore();
        store.getAllProducts().add(product);
        String response = "Product is added to the cart";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}

