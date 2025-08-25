import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Conversor {

    public void converteimagem(String inputpath,String outputpath,String filetype) {
        try {
            File inputfile = new File(inputpath);
            BufferedImage imagem = ImageIO.read(inputfile);
            if (imagem == null) {
                System.err.println("Imagem não Encontrada");

            } else {
                File outputfile = new File(outputpath);
                boolean sucess = ImageIO.write(imagem, filetype, outputfile);
                if (sucess) {
                    System.out.println("Imagem convertida com sucesso");

                } else {
                    System.out.println("A imagem não pode ser convertida");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean validateFiletype(String filetype) {
        String[] formats = ImageIO.getReaderFormatNames();
        for(String formato : formats) {
            if(formato.equals(filetype)) {
                return true;
            }
        }
        return false;
    }
    public boolean validateInput(String inputpath) {
        String[] formats = ImageIO.getReaderFormatNames();
        for(String formato : formats){
            String formated = String.format(".%s",formato);
            if(inputpath.endsWith(formated)) {
                return true;
            }
        }
        return false;
    }
}
