package com.bytepart.web;

import com.bytepart.web.handlers.ConfigHandler;
import com.bytepart.web.handlers.HomeHandler;
import com.bytepart.web.handlers.RepoHandler;
import com.bytepart.web.handlers.WebHookHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class WebServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/home", new HomeHandler());
        server.createContext("/webhook", new WebHookHandler());
        server.createContext("/repos", new RepoHandler());
        server.createContext("/config/", new ConfigHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}
