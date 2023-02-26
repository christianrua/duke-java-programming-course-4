package com.dukeCourse4.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class readAndPrint {
    public void readAndPrintFile() throws IOException{
        Path p = Paths.get("src/com/dukeCourse4/data/nov20quakedatasmall.atom");
        BufferedReader reader = Files.newBufferedReader(p);
        while (true){
            String line = reader.readLine();
            if(line == null){
                break;
            }
            System.out.println(line);
        }
    }

    public void readAndPrintUrl() throws IOException {
        URL source = new URL("https://www.dukelearntoprogram.com/java/hello_unicode.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(source.openStream()));
        while(true){
            String line = reader.readLine();
            if(line == null){
                break;
            }
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException{
        readAndPrint rap = new readAndPrint();
        rap.readAndPrintUrl();
    }

}
