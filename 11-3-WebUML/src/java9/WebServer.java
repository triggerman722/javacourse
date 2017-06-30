package java9;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

public class WebServer {
    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/uml", new UmlHandler());
        server.createContext("/", new AppHandler());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
    }
    class UmlHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            ByteArrayOutputStream result = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = exchange.getRequestBody().read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }

            String source = "@startuml\n";
            source += URLDecoder.decode(result.toString("UTF-8").split("=")[1], "UTF-8") + "\n";
            source += "@enduml\n";

            SourceStringReader sourceStringReader = new SourceStringReader(source);
            final ByteArrayOutputStream bos = new ByteArrayOutputStream();
            sourceStringReader.outputImage(bos, new FileFormatOption(FileFormat.SVG));
            bos.close();
            final String svg = new String(bos.toByteArray(), Charset.forName("UTF-8"));
            Headers responseHeaders = exchange.getResponseHeaders();
            responseHeaders.set("Content-Type", "image/svg+xml");
            exchange.sendResponseHeaders(200, svg.length());
            OutputStream os = exchange.getResponseBody();
            os.write(svg.getBytes());
            os.close();
        }
    }
    class AppHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            byte [] bytes = ClassLoader.getSystemResourceAsStream("index.html").readAllBytes();

            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }

    public static void main(String[] args) throws IOException {
        WebServer webServer = new WebServer();
        webServer.start();
    }
}

