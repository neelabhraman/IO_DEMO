import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import static  java.lang.System.out;

public class HelloWorld {



    public static  void main (String args[]){

        out.println("Inside Main method");
        String filePath = new File("").getAbsolutePath();
        out.println (filePath);
        try(
        //InputStreamReader obj = new InputStreamReader(System.in);
        FileReader obj= new FileReader(filePath+"/static/change.log");
        BufferedReader  bufferedReader= new BufferedReader(obj);) {
            int i;
            while((i=bufferedReader.read())!=-1){
                System.out.print((char)i);
            }
        }catch (Exception e){
            out.println("Exception: " + e);
        }

    }

}