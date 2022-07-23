import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer o conexao(protocolo) HTTP e buscar o Top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient cliente =HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);
        // extrair o dados interessantes(mtitulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);
    
        // exibir e manipular os dados da API
        for (Map<String,String> map : listaDeFilmes) {
            System.out.println(map.get("title"));
            System.out.println(map.get("image"));
            System.out.println(map.get("imDbRating")+"\n");
        }
    }
}
