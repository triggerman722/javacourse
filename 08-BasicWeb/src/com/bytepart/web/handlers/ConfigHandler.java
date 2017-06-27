package com.bytepart.web.handlers;

import com.bytepart.web.service.ConfigService;
import com.bytepart.web.service.RepoService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class ConfigHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        ConfigService configService = new ConfigService();
        RepoService repoService = new RepoService();

        configService.addObserver(repoService);


        String response = configService.getConfig("owner", "repo");
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();

    }
}
