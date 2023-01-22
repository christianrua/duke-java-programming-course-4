package com.dukeCourse4.week3.GeneratingRandomText;

import com.dukeCourse4.week3.GeneratingRandomText.MarkovRunner;
import edu.duke.FileResource;

import java.util.ArrayList;

public class tester {




    public static void main(String[] args) {

        MarkovRunner mr = new MarkovRunner();

//        BaseMarkov markovZero = mr.getMarkovByLevel(0);
        //String data =mr.getData();
        // mr.runMarkov(markovZero, data, 101);

//        BaseMarkov markovOne = mr.getMarkovByLevel(1);
//        markovOne.setTraining("this is a test yes this is a test.");
//        ArrayList<String> result1 = markovOne.getFollows("t");
//        System.out.println(result1);
//        ArrayList<String> result2 = markovOne.getFollows("e");
//        System.out.println(result2);
//        ArrayList<String> result3 = markovOne.getFollows("es");
//        System.out.println(result3);
//        ArrayList<String> result4 = markovOne.getFollows(".");
//        System.out.println(result4);

//        markovOne.setTraining(mr.getData());
//        ArrayList<String> result1 = markovOne.getFollows("t");
//        System.out.println("array size using confucius.txt " + result1.size());

//        mr.runMarkov(markovOne, mr.getData(), 42);
//        BaseMarkov markovFour = mr.getMarkovByLevel(4);
//        mr.runMarkov(markovFour, mr.getData(), 25);

//        BaseMarkov markovSix = mr.getMarkovByLevel(6);
//        mr.runMarkov(markovSix, mr.getData(), 38);

//        mr.runMarkov(0,mr.getData(),88);

//        BaseMarkov someMarkov = new BaseMarkov(0);
//        someMarkov.setTraining(mr.getData());
//        ArrayList<String> response = someMarkov.getFollows("th");
//        System.out.println("the array size is " + response.size());

//        mr.runMarkov(1,mr.getData(),273);
//        mr.runMarkov(4,mr.getData(),371);
        mr.runMarkov(8,mr.getData(),365);
    }
}
