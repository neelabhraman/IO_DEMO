package main;

import logic.IoExecutor;

import static java.lang.System.out;

public class ThoughtForTheDay {
        public static  void main (String args[]){
        out.println("Inside Main method");
        IoExecutor ioExecutor=new IoExecutor();
        String inputText=ioExecutor.readFileWrapper();
        ioExecutor.createFile();
        ioExecutor.writeFile(inputText);
        out.println("Exiting Main method");
    }



}
