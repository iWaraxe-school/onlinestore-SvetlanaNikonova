package com.issoft.store.httpServer;

import com.issoft.store.httpServer.handler.CartHandler;
import com.issoft.store.httpServer.handler.CategoryHandler;
import com.sun.net.httpserver.BasicAuthenticator;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class AppHttpServer {

    public static final String USERNAME = "admin";
    public static final String PASSWORD = "password";

    public void startServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            createContext(server,"/categories", new CategoryHandler());
            createContext(server,"/cart", new CartHandler());
            server.setExecutor(null);
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void createContext(HttpServer server, String path, HttpHandler handler) {
        server.createContext(path, handler).setAuthenticator(new BasicAuthenticator("test") {
            @Override
            public boolean checkCredentials(String user, String pwd) {
                return user.equals(USERNAME) && pwd.equals(PASSWORD);
            }
        });
    }
}


