package com.dukeCourse4.week4;

import edu.duke.FileResource;

import java.io.PrintStream;

public class HelloWorld {
    public static void main (String[] args){
        if (args.length == 0){
            System.out.println("Please specify the filename");
            System.exit(1);
        }
        FileResource hello = new FileResource(args[0]);
        for(String line : hello.lines()){
            System.out.println(line);
        }
    }
}
