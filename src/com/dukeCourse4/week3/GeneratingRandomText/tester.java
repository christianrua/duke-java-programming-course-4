package com.dukeCourse4.week3.GeneratingRandomText;

import com.dukeCourse4.week3.GeneratingRandomText.MarkovRunner;
import edu.duke.FileResource;

import java.util.ArrayList;

public class tester {




    public static void main(String[] args) {

        MarkovRunner mr = new MarkovRunner();
        FileResource fr = new FileResource("com/dukeCourse4/data/confucius.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');

        mr.markovSetTrainingString(st,0);
        mr.runMarkovZero();

//        ArrayList<String> response = mo.getFollows("t");
//        System.out.println("Using the MarkovOne class, and the letter t in the getFollows method I got a list with size " + response.size());

//        MarkovOne mo = new MarkovOne();
//        mo.setTraining("this is a test yes this is a test.");
//        ArrayList<String> responseT = mo.getFollows("t");
//        System.out.println("getFollows with t " + responseT);
//        ArrayList<String> responseE = mo.getFollows("e");
//        System.out.println("getFollows with s " + responseE);
//        ArrayList<String> responseES = mo.getFollows("es");
//        System.out.println("getFollows with es " + responseES);


//        mo.setTraining("an apple a day is really great");
//        String result = mo.getRandomText(20);
//        System.out.println("this is the random text generated: " + result);

//        MarkovRunner mr = new MarkovRunner();
//        mr.runMarkovOne();



    }
}
