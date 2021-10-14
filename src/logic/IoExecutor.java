package  logic;

import constants.IOConstants;
import java.io.*;
import static java.lang.System.out;

import org.apache.log4j.Logger;

public class IoExecutor{

    static Logger log = Logger.getLogger(IoExecutor.class.getName());

    public static final String FILE_ABS_PATH = new File("").getAbsolutePath();
    public static int count=1;

    /*This is a wrapper file which does 2 things
    * 1. Get inputs from user from console
    * 2. Based in input create the Reader Obj and read the input from console stream or saved file*/
    public String readFileWrapper(){
        log.info("Inside readFileWrapper method");
        String returnValue="";
        int userInput=getInputFromUser();
        log.info("userInput is: "+userInput);
        if(userInput== IOConstants.NUMBER_ONE_ASCII){
            out.println(IOConstants.USER_OPTION_1_CONT);
            InputStreamReader obj = new InputStreamReader(System.in);
            returnValue= readFile(obj);
        }
        else if(userInput==IOConstants.NUMBER_TWO_ASCII){
            FileReader obj=null;
            try {
                obj = new FileReader(FILE_ABS_PATH + IOConstants.FILE_INPUT_PATH);
                returnValue= readFile(obj);
                obj.close();
            }catch (IOException | ClassCastException e){
                out.println("Exception in readFileWrapper method: " + e);
                log.error("Exception in readFileWrapper method: " + e);
            }finally {
                try{
                    obj.close();
                }catch (Exception e){
                    out.println("Unrecoverable Exception in readFileWrapper method: " + e);
                    log.error("Unrecoverable Exception in readFileWrapper method: " + e);
                }
            }
        }
        else{
            out.println("Invalid Input Provided");
            System.exit(-1);
        }
        log.info("Exiting readFileWrapper method");
        return returnValue;
    }
    /*This is an overloaded method
     * This version takes input from file stream*/
    public String readFile(FileReader fileReader) {
        log.info("Inside readFile method");
        log.info("fileReader instanceof FileReader: "+ (fileReader instanceof FileReader));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\r\n");
            }
        } catch (IOException | ClassCastException e) {
            out.println("Exception in readFile method: " + e);
            log.error("Exception in readFile method: " + e);
        }
        log.info("Exiting readFile method");
        return stringBuilder.toString();
    }
    /*This is an overloaded method
     * This version taken input from user console*/
    public String readFile(InputStreamReader inputStreamReader) {
        log.info("Inside readFile method");
        log.info("inputStreamReader instanceof InputStreamReader: "+(inputStreamReader instanceof InputStreamReader));
        String line="";
        StringBuilder stringBuilder = new StringBuilder();
        out.print("Enter the \"Thought For the Day\": ");
        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (!IOConstants.STOP_INPUT.equals(line)) {
                line = bufferedReader.readLine();
                if(!IOConstants.STOP_INPUT.equals(line)) {
                    stringBuilder.append(line + "\r\n");
                }
            }
        } catch (Exception e) {
            out.println("Exception in readFile method: " + e);
            log.error("Exception in readFile method: " + e);
        }
        log.info("Exiting readFile method");
        return stringBuilder.toString();
    }
    /*This will create a file if not present, if present will not do anything*/
    public boolean createFile(){
        log.info("Inside createFile method");
        boolean isCreated=false;
        try{
            File myNewFileCreated = new File(FILE_ABS_PATH+IOConstants.FILE_OUT_PATH+count+IOConstants.DOT_TXT);
            isCreated=myNewFileCreated.createNewFile();
            if(isCreated) {
                log.info("File created: " + myNewFileCreated.getName());
            }
        }catch (IOException | ClassCastException e){
            out.println("Exception in createFile method: " + e);
            log.error("Exception in createFile method: " + e);
        }
        log.info("Exiting createFile method");
        return isCreated;
    }
    /*This will write the file to the output directory*/
    public void writeFile(String inputText){
        log.info("Inside writeFile method");
        try{
            FileWriter openedNewFile= new FileWriter(FILE_ABS_PATH+IOConstants.FILE_OUT_PATH+count+IOConstants.DOT_TXT);
            openedNewFile.write(inputText);
            openedNewFile.close();
        }catch (IOException | ClassCastException e) {
            out.println("Exception in writeFile method: " + e);
            log.error("Exception in writeFile method: " + e);
        }
        log.info("Exiting writeFile method");
    }

    public int getInputFromUser(){
        int userInput=-1;
        out.println(IOConstants.USER_OPTION_1);
        out.println(IOConstants.USER_OPTION_2);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            userInput = bufferedReader.read();
        }
        catch (IOException e) {
            out.println("Exception in getInputFromUser method: " + e);
            log.error("Exception in getInputFromUser method: " + e);
        }
        return userInput;
    }

}