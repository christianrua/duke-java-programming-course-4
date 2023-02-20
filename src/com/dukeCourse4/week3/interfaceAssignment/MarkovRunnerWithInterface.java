package com.dukeCourse4.week3.interfaceAssignment;

/**
 * Write a description of class MarkovRunner here.
 *
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;
import com.dukeCourse4.week3.interfaceAssignment.MarkovModel;
import com.dukeCourse4.week3.interfaceAssignment.EfficientMarkovModel;

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size, int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov.toString());
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        int seed = 0;

        MarkovModel mz = new MarkovModel(0);
        runModel(mz, st, size, seed);

        MarkovModel mOne = new MarkovModel(1);
        runModel(mOne, st, size, seed);

        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);

        MarkovModel mFour = new MarkovModel(4);
        runModel(mFour, st, size, seed);

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

    public void testHashMap(){
//        EfficientMarkovModel mTwo = new EfficientMarkovModel(2);
//        mTwo.setRandom(42);
//        mTwo.setTraining("yes-this-is-a-thin-pretty-pink-thistle");
//        //mTwo.printHashMapInfo();
//        String st = mTwo.getRandomText(50);
//        printOut(st);

        EfficientMarkovModel mFive = new EfficientMarkovModel(5);
        FileResource fr = new FileResource("com/dukeCourse4/data/confucius.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');
        runModel(mFive , st, 0, 531);
    }

    public void compareMethods(){
        MarkovModel markovModel2 = new MarkovModel(2);
        EfficientMarkovModel efficientMarkovModel2 = new EfficientMarkovModel(2);

        FileResource fr = new FileResource("com/dukeCourse4/data/hawthorne.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 1000;
        int seed = 42;

        final long start = System.nanoTime();
        runModel(markovModel2, st, size, seed);
        final long end = System.nanoTime();

        System.out.println("markovModel2 Took: " + ((end - start) / 1000000) + "ms");
        System.out.println("markovModel2 Took: " + (end - start)/ 1000000000 + " seconds");

        final long start2 = System.nanoTime();
        runModel(efficientMarkovModel2, st, size, seed);
        final long end2 = System.nanoTime();

        System.out.println("efficientMarkovModel2 Took: " + ((end2 - start2) / 1000000) + "ms");
        System.out.println("efficientMarkovModel2Took: " + (end2 - start2)/ 1000000000 + " seconds");
    }

}
