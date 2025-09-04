import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Conversor {
    public void converteimagem(String inputpath, String outputpath, String filetype) {
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
        return Arrays.asList(formats).contains(filetype);

    }

    public boolean validateInput(String inputpath) {
            File input = new File(inputpath);
            if(!input.exists() && !input.canRead()) {
                return false;
            }
            String[] formatos = ImageIO.getReaderFormatNames();
            return Arrays.stream(formatos)
                    .anyMatch(formato -> inputpath.endsWith("." + formato));
    }

    public String GetInput() {
        String inputpath;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite o Caminho Da Imagem");
            inputpath = scanner.nextLine();
            if(validateInput(inputpath)) {
                return inputpath;
            } else {
                System.err.println("Arquivo Inválido");
            }
        }
    }

    public String GetOutput() {
        String outputfile;
        String outputdirectory;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite o diretório onde a nova imagem irá ser armazenada");
            outputdirectory = scanner.nextLine();
            File output = new File(outputdirectory);
            if (output.exists() && output.isDirectory()) {
                System.out.println("Digite o nome do arquivo");
                outputfile = scanner.nextLine();
                break;
            } else {
                System.err.println("Diretório Não Existe");
            }

        }
        return String.format("%s%s",outputdirectory,outputfile);
    }
    public String GetFileType() {
        String filetype;
        Scanner scanner = new Scanner(System.in);
        String[] formats = ImageIO.getReaderFormatNames();
        while (true) {
            System.out.println(Arrays.toString(formats));
            System.out.println("Digite o Tipo de arquivo");
            filetype = scanner.nextLine();
            if(validateFiletype(filetype)) {
                scanner.close();
                return filetype;
            } else {
                System.err.println("Formato de Arquivo não permitido");
            }
        }
    }
}

