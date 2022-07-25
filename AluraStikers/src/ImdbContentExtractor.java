import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor implements ContentExtractor{
    
    public List<Contents> extractContent(String json){
        // extrair o dados interessantes(mtitulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String,String>> attributeList = parser.parse(json);

        List<Contents> contents = new ArrayList<>();

        //popular a lista de conteudos
        for (Map<String,String> attributes: attributeList) {
            String title =  attributes.get("title");
            String urlimage = attributes.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            var content = new Contents(title, urlimage);

            contents.add(content);
        }


        return contents;
    }
}
