package com.dukeCourse4.week3.GeneratingRandomText;

/**
 * Write a description of class MarkovRunner here.
 *
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;
import java.util.Optional;
import java.util.OptionalInt;

public class MarkovRunner {

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

    public BaseMarkov getMarkovByLevel(Integer levelValue){
        System.out.println("Returning markov level " + levelValue);
        return new BaseMarkov(levelValue);
    }

    public String getData(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        return st;
    }

    public void runMarkov(BaseMarkov markov, String st) {
        markov.setTraining(st);
        for(int k=0; k < 3; k++){
            String text = markov.getRandomText(500);
            printOut(text);
        }
    }

    public void runMarkov(BaseMarkov markov, String st, Integer seed_value) {
        markov.setRandom(seed_value);
        runMarkov(markov, st);
    }

    public void runMarkov(Integer markov_level, String st, Integer seed_value){
        BaseMarkov markov = getMarkovByLevel(markov_level);
        markov.setRandom(seed_value);
        runMarkov(markov, st);
    }


}
