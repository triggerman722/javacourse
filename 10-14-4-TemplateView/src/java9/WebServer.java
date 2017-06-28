package java9;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class WebServer {
    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/league", new LeagueHandler());
        server.setExecutor(null);
        server.start();
    }
    class LeagueHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Player player = new Player();
            player.setName("Some Guy");
            player.setNumber(19);
            Team team1 = new Team();
            team1.setCity("Toronto");
            team1.setName("Oak Chuckles");
            team1.getPlayers().add(player);

            String rawHTML = "<html><body><h1>%s <i>%s</i><h1><hr>" +
                    "<h3> Player Roster:</h3>" +
                    "<table border=1>" +
                    "<tr><td>Player Number</td><td>Player Name</td></tr>" +
                    "<tr><td>%s</td><td>%s</td></tr>" +
                    "</table>" +
                    "</body></html>";
            String response = String.format(rawHTML, team1.getCity(), team1.getName(), player.getNumber(), player.getName());

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    class Player {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        private int number;
    }

    class Team {
        private String name;
        private String city;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        private List<Player> players = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        WebServer webServer = new WebServer();
        webServer.start();
    }
}

