package com.dukeCourse4.week3.GeneratingRandomText;

/**
 * Write a description of class MarkovRunner here.
 *
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

public class MarkovRunner {


    MarkovZero markovZero = new MarkovZero();
    MarkovOne markovOne = new MarkovOne();
    MarkovTwo markovTwo = new MarkovTwo();

    private String getData(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        return st;
    }

    public void runMarkovZero() {
        String st = getData();
        //markov.setRandom(101);
        markovZero.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markovZero.getRandomText(500);
            printOut(text);
        }
    }

    public void runMarkovOne(){
        String st = getData();
        markovOne.setRandom(42);
        markovOne.setTraining(st);
        for(int k=0; k < 3;k++){
            String text = markovOne.getRandomText(500);
            printOut(text);
        }
    }

    public void runMarkovTwo(){
        String st = getData();
        //String st = "this is a test yes a test";
        markovTwo.setTraining(st);
        for(int k=0; k < 3;k++){
            String text = markovTwo.getRandomText(500);
            printOut(text);
        }
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    public void markovSetTrainingString(String training_string, Integer markov_number){
        switch (markov_number){
            case 0:
                markovZero.setTraining(training_string);
                break;
            case 1:
                markovOne.setTraining(training_string);
                break;
            case 2:
                markovTwo.setTraining(training_string);
                break;
        }
    }
}
