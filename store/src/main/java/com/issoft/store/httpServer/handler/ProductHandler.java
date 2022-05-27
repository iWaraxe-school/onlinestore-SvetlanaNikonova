package com.issoft.store.httpServer.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.issoft.domain.Category;
import com.issoft.domain.Product;
import com.issoft.store.helpers.populators.DBPopulator;
import com.issoft.store.helpers.populators.HttpPopulator;
import com.issoft.store.helpers.populators.ProductCategoryEnum;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        List<Product> products;
        try {
            products = new HttpPopulator().getProductsForCategory(ProductCategoryEnum.MILK);
        } catch (Exception e) {
            e.printStackTrace();
            products = new ArrayList<>();
        }

        ObjectMapper mapper = new ObjectMapper();
        OutputStream out = null;

        try {
            byte[] jsonInBytes = mapper.writeValueAsBytes(products);
            Headers headers = exchange.getResponseHeaders();
            headers.add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, jsonInBytes.length);
            out = exchange.getResponseBody();
            out.write(jsonInBytes);
        } finally {
            if(Objects.nonNull(out)) {
                out.close();
            }
        }
    }
}
