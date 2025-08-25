import javax.imageio.ImageIO;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputpath;
        String outputpath;
        String filetype;
        String outputname;
        String [] formatos = ImageIO.getReaderFormatNames();
        Conversor conversor = new Conversor();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Conversor de Imagem");
        System.out.println("--------------------");
        System.out.println("Digite onde a Imagem está localizada");
        inputpath = scanner.nextLine();
        if(!conversor.validateInput(inputpath)) {
            System.err.println("Tipo de arquivo não suportado");
            return;
        }
        System.out.println("Digite onde a nova Image será armazenada");
        outputpath = scanner.nextLine();
        System.out.println("Digite o Nome do arquivo:");
        outputname = scanner.nextLine();
        System.out.println("Digite o Formato da Imagem");
        System.out.println("Formatos Permitidos:");
        System.out.println(Arrays.toString(formatos));
        filetype = scanner.nextLine();
        if(!conversor.validateFiletype(filetype)) {
            System.err.println("Formato de arquivo incompativel");
            return;
        }
        String outputformat = String.format("%s%s.%s",outputpath,outputname,filetype);
        conversor.converteimagem(inputpath,outputformat,filetype);
    }
}