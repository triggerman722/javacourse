package com.bytepart.web.handlers;

import com.bytepart.web.models.Repository;
import com.bytepart.web.repository.RepoRepository;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

public class RepoHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        RepoRepository repoRepository = new RepoRepository();

        String stringId = exchange.getRequestURI().getPath().split("/")[2];
        int i = Integer.parseInt(stringId);
        try {
            Repository repository = repoRepository.getRepo(i);

            String response = new Gson().toJson(repository);
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
