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
        server.createContext("/league/toronto", new TorontoHandler());
        server.createContext("/league/london", new LondonHandler());
        server.setExecutor(null);
        server.start();
    }
    class BasePage {
        String rawHTML = "<html><title>%s</title><body style=\"background-color:pink\">" +
                "<img align=\"middle\" src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/North_American_Hockey_League_Logo.svg/436px-North_American_Hockey_League_Logo.svg.png\">" +
                "<h3> Player Roster:</h3>%s</body></html>";
        public String render(String title, String body) {
            return String.format(rawHTML, title, body);
        }
    }
    class LondonHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Player player = new Player();
            player.setName("Some Guy");
            player.setNumber(19);
            Team team1 = new Team();
            team1.setCity("London");
            team1.setName("Kmornings");
            team1.getPlayers().add(player);

            BasePage basePage = new BasePage();
            String teamTitle = "Welcome to the team site for the " + team1.getCity() + " " + team1.getName() + "!!!!";
            String rawHTML =
                    "<table border=1>" +
                    "<tr><td>Player Number</td><td>Player Name</td></tr>" +
                    "<tr><td>%s</td><td>%s</td></tr>" +
                    "</table>";
            String firstStage = String.format(rawHTML, player.getNumber(), player.getName());
            String secondStage = basePage.render(teamTitle, firstStage);
            exchange.sendResponseHeaders(200, secondStage.length());
            OutputStream os = exchange.getResponseBody();
            os.write(secondStage.getBytes());
            os.close();
        }
    }
    class TorontoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            Player player = new Player();
            player.setName("Toronto Player");
            player.setNumber(26);
            Team team1 = new Team();
            team1.setCity("Toronto");
            team1.setName("Oak Chuckles");
            team1.getPlayers().add(player);

            BasePage basePage = new BasePage();
            String teamTitle = "Welcome to the team site for the " + team1.getCity() + " " + team1.getName() + "!!!!";
            String rawHTML =
                    "<table border=1>" +
                            "<tr><td>Player Number</td><td>Player Name</td></tr>" +
                            "<tr><td>%s</td><td>%s</td></tr>" +
                            "</table>";
            String firstStage = String.format(rawHTML, player.getNumber(), player.getName());
            String secondStage = basePage.render(teamTitle, firstStage);
            exchange.sendResponseHeaders(200, secondStage.length());
            OutputStream os = exchange.getResponseBody();
            os.write(secondStage.getBytes());
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

