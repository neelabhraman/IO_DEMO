package main;

import logic.IoExecutor;

import org.apache.log4j.Logger;

public class ThoughtForTheDay {
        static Logger log = Logger.getLogger(ThoughtForTheDay.class.getName());

        public static  void main (String args[]){
        log.info("Inside Main method");
        IoExecutor ioExecutor=new IoExecutor();
        String inputText=ioExecutor.readFileWrapper();
        ioExecutor.createFile();
        ioExecutor.writeFile(inputText);
        log.info("Exiting Main method");
    }



}
