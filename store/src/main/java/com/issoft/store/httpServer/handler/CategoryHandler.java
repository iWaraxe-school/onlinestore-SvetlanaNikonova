package com.issoft.store.httpServer.handler;

import com.issoft.domain.Category;
import com.issoft.store.helpers.populators.DBPopulator;
import com.issoft.store.helpers.populators.HttpPopulator;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
//import io.restassured.mapper.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoryHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        List<Category> categories;
        try {
            categories = new HttpPopulator().getCategories();
        } catch (Exception e) {
            e.printStackTrace();
            categories = new ArrayList<>();
        }

        ObjectMapper mapper = new ObjectMapper();
        OutputStream out = null;
            /*    @Override
                public Object deserialize(ObjectMapperDeserializationContext objectMapperDeserializationContext) {
                    return null;
                }

                @Override
                public Object serialize(ObjectMapperSerializationContext objectMapperSerializationContext) {
                    return null;
                }*/


            try {
                byte[] jsonInBytes = mapper.writeValueAsBytes(categories);
                Headers headers = exchange.getRequestHeaders();
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
