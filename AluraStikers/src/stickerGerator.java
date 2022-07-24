import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class stickerGerator {

    void create(InputStream inputStream, String  fileName) throws Exception{

        //leitura da imagem
        //InputStream inputStream = new FileInputStream(new File("entrada/filme_.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage originalImage = ImageIO.read(inputStream);

        //criar uma nova imagem em memoria com transparencia e com novo tamanho
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newheight = height + 200;
        BufferedImage newImage = new BufferedImage(width,newheight,BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        //configurar a fonte
        var font = new Font(Font.SANS_SERIF,Font.CENTER_BASELINE,100);
        graphics.setColor(Color.CYAN);
        graphics.setFont(font);

        //escrever uma frase na nova imagem 
        graphics.drawString("TOPZERA", 100, newheight - 100);

        // escrever a imagem nova em um arquivo 
        ImageIO.write(newImage, "png", new File("out/"+fileName));

    }
    
}
