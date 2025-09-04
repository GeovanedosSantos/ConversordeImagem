
public class Main {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();
        String input = conversor.Getinput();
        String output = conversor.GetOutput();
        String filetype = conversor.GetFileType();
        String outputpath = String.format("%s.%s",output,filetype);
        conversor.converteimagem(input,outputpath,filetype);
    }
}