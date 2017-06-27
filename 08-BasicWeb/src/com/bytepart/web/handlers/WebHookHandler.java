package com.bytepart.web.handlers;

import com.bytepart.web.models.CCEvent;
import com.bytepart.web.repository.RepoRepository;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;

public class WebHookHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String stringBody = "";
        InputStreamReader isr =  new InputStreamReader(exchange.getRequestBody(),"utf-8");
        BufferedReader br = new BufferedReader(isr);
        int b;
        StringBuilder buf = new StringBuilder(512);
        while ((b = br.read()) != -1) {
            buf.append((char) b);
        }

        br.close();
        isr.close();

        stringBody = buf.toString();

        Gson gson = new Gson();

        CCEvent eventResult = gson.fromJson(stringBody, CCEvent.class);

        RepoRepository repoRepository = new RepoRepository();
        try {
            repoRepository.addRepo(eventResult.getRepository());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String response = "";
        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
