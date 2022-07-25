import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // fazer o conexao(protocolo) HTTP e buscar o Top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        var extractor = new  ImdbContentExtractor();

        //String url = "https://api.nasa.gov/planetary/apod?api_key=hxekMw06RiONVbx9yecnqecMHa9UfQHpvaZdJaJK&start_date=2022-05-20&end_date=2022-05-24";
        //var extractor = new  NasaContentExtractor();

        var http = new httpClient();
        String json = http.buscaDados(url);
        
        // exibir e manipular os dados da API
        List<Contents> content = extractor.extractContent(json);

        for (int i = 0; i < 4 ; i++) {
            
            Contents contents = content.get(i);

            InputStream inputStream = new URL(contents.getUrlimage()).openStream(); 
            String fileName = contents.getTitle() + ".png";  

            var gerator = new stickerGerator();
            gerator.create(inputStream,  fileName);
            
            System.out.println(contents.getTitle()+"\n");
            //System.out.println(map.get("title"));
            //System.out.println(map.get("image"));
           // System.out.println(map.get("imDbRating")+"\n");
        }
    }
}
