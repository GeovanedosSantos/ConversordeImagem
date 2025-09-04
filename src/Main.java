
public class Main {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        String input = conversor.getInput();
        String output = conversor.getOutput();
        String filetype = conversor.getFileType();
        String outputpath = String.format("%s.%s",output,filetype);
        conversor.converteimagem(input,outputpath,filetype);
    }
}