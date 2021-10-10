import java.io.*;
import static  java.lang.System.out;

public class HelloWorld {
    public static final String FILE_OUT_PATH="\\out\\production\\Oct1_IO_DEMO\\Thoughts";
    public static int count=0;
    public static final String DOT_TXT=".txt";
    public static final String FILE_ABS_PATH = new File("").getAbsolutePath();
    public static final String STOP_INPUT="$STOP";

    public static  void main (String args[]){
        out.println("Inside Main method");
        count++;
        HelloWorld helloWorld=new HelloWorld();
        String inputText=helloWorld.readFileWrapper();
        helloWorld.createFile();
        helloWorld.writeFile(inputText);
        out.println("Exiting Main method");
    }

    public String readFileWrapper(){
        out.println("Inside readFileWrapper method");
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try (//InputStreamReader obj = new InputStreamReader(System.in);
                FileReader obj = new FileReader(FILE_ABS_PATH + "/static/change.log");
            ) {
            return readFile(obj);
        } catch (IOException | ClassCastException e) {
            out.println("Exception in readFileWrapper method: " + e);
        }
        out.println("Exiting readFileWrapper method");
        return stringBuilder.toString();
    }
    /*This is an overloaded method
     * This version takes input from file stream*/
    public String readFile(FileReader fileReader) {
        out.println("Inside readFile method");
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\r\n");
            }
        } catch (IOException | ClassCastException e) {
            out.println("Exception in readFile method: " + e);
        }
        out.println("Exiting readFile method");
        return stringBuilder.toString();
    }
    /*This is an overloaded method
    * This version taken input from user console*/
    public String readFile(InputStreamReader inputStreamReader) {
        out.println("Inside readFile method");
        String line="";
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (!STOP_INPUT.equals(line)) {
                line = bufferedReader.readLine();
                if(!STOP_INPUT.equals(line)) {
                    stringBuilder.append(line + "\r\n");
                }
            }
        } catch (IOException | ClassCastException e) {
            out.println("Exception in readFile method: " + e);
        }
        out.println("Exiting readFile method");
        return stringBuilder.toString();
    }
    public boolean createFile(){
        out.println("Inside createFile method");
        boolean isCreated=false;
        try{
            File myNewFileCreated = new File(FILE_ABS_PATH+FILE_OUT_PATH+count+DOT_TXT);
            isCreated=myNewFileCreated.createNewFile();
            if(isCreated) {
                out.println("File created: " + myNewFileCreated.getName());
            }
        }catch (IOException | ClassCastException e){
            out.println("Exception in createFile method: " + e);
        }
        out.println("Exiting createFile method");
        return isCreated;
    }
    public void writeFile(String inputText){
        out.println("Inside writeFile method");
        try{
            FileWriter openedNewFile= new FileWriter(FILE_ABS_PATH+FILE_OUT_PATH+count+DOT_TXT);
            openedNewFile.write(inputText);
            openedNewFile.close();
        }catch (IOException | ClassCastException e) {
            out.println("Exception in writeFile method: " + e);
        }
        out.println("Exiting writeFile method");
    }

}
