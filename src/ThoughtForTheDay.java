import java.io.*;
import static  java.lang.System.out;

public class ThoughtForTheDay {
    public static final String FILE_OUT_PATH="\\out\\production\\Oct1_IO_DEMO\\Thoughts";
    public static int count=0;
    public static final String DOT_TXT=".txt";
    public static final String FILE_ABS_PATH = new File("").getAbsolutePath();
    public static final String STOP_INPUT="$STOP";
    public static final int NUMBER_ONE_ASCII=49;
    public static final int NUMBER_TWO_ASCII=50;

    public static  void main (String args[]){
        out.println("Inside Main method");
        count++;
        ThoughtForTheDay helloWorld=new ThoughtForTheDay();
        String inputText=helloWorld.readFileWrapper();
        helloWorld.createFile();
        helloWorld.writeFile(inputText);
        out.println("Exiting Main method");
    }

    public String readFileWrapper(){
        out.println("Inside readFileWrapper method");
        String returnValue="";
        int userInput=getInputFromUser();
        out.println("userInput is: "+userInput);
        if(userInput==NUMBER_ONE_ASCII){
            InputStreamReader obj = new InputStreamReader(System.in);
            returnValue= readFile(obj);
        }
        else if(userInput==NUMBER_TWO_ASCII){
            FileReader obj=null;
            try {
                obj = new FileReader(FILE_ABS_PATH + "/static/change.log");
                returnValue= readFile(obj);
                obj.close();
            }catch (IOException | ClassCastException e){
                out.println("Exception in readFileWrapper method: " + e);
            }finally {
                try{
                obj.close();
                }catch (Exception e){
                    out.println("Unrecoverable Exception in readFileWrapper method: " + e);
                    e.printStackTrace();
                }
            }
        }
        else{
            out.println("Invalid Input Provided");
            System.exit(-1);
        }
        out.println("Exiting readFileWrapper method");
        return returnValue;
    }
    /*This is an overloaded method
     * This version takes input from file stream*/
    public String readFile(FileReader fileReader) {
        out.println("Inside readFile method");
        out.println("fileReader instanceof FileReader: "+ (fileReader instanceof FileReader));
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
        out.println("inputStreamReader instanceof InputStreamReader: "+(inputStreamReader instanceof InputStreamReader));
        String line="";
        StringBuilder stringBuilder = new StringBuilder();
        out.print("Enter the \"Thought For the Day\": ");
        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (!STOP_INPUT.equals(line)) {
                line = bufferedReader.readLine();
                if(!STOP_INPUT.equals(line)) {
                    stringBuilder.append(line + "\r\n");
                }
            }
        } catch (Exception e) {
            out.println("Exception in readFile method: " + e);
        }
        out.println("Exiting readFile method");
        return stringBuilder.toString();
    }
    /*This will create a file if not present, if present will not do anything*/
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
    /*This will write the file to the output directory*/
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

    public int getInputFromUser(){
        int userInput=-1;
        out.println("Press 1 to Enter new Thought");
        out.println("Press 2 to copy file from the path /static");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            userInput = bufferedReader.read();
        }
        catch (IOException e) {
            out.println("Exception in getInputFromUser method: " + e);
        }
        return userInput;
    }

}
