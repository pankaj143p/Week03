package src.com.problems.fileandbufferreader;
import java.io.FileReader;
import java.io.IOException;
class ReadFile{
    public static void main(String[] args) {
        try(FileReader fr=new FileReader("myfile.txt")) {
             int i;
             while((i=fr.read())!=-1){
                 System.out.println((char)i+" ");
             }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}