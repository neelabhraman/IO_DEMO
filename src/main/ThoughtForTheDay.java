package main;

import logic.IoExecutor;
import static java.lang.System.out;

import org.apache.log4j.Logger;

public class ThoughtForTheDay {
        static Logger log = Logger.getLogger(ThoughtForTheDay.class.getName());

        public static  void main (String args[]){
        log.info("Inside Main method");
        IoExecutor ioExecutor=new IoExecutor();
        String inputText=ioExecutor.readFileWrapper();
        ioExecutor.createFile();
        ioExecutor.writeFile(inputText);
        out.println("Exiting Main method");
    }



}
