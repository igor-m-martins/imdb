import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws Exception {
        var token_access = System.getenv(“$TMP”);
        var url = String.format("https://imdb-api.com/en/API/Title/%s/tt1832382",token_access);
        URI uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).build();

        String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

        System.out.println(json);
    }
}
