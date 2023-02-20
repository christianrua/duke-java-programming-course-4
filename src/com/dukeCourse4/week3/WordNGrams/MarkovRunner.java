package com.dukeCourse4.week3.WordNGrams;
import com.dukeCourse4.week3.interfaceAssignment.EfficientMarkovModel;
import com.dukeCourse4.week3.interfaceAssignment.MarkovModel;
import edu.duke.*;

public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){
        markov.setTraining(text);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runModel(IMarkovModel markov, String text, int size, int seed){
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWordOne markovWord = new MarkovWordOne();
        runModel(markovWord, st, 120, 139);
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

    public void testGetFollows(){
        String st = "this is just a test yes this is a simple test";
        st = st.replace('\n', ' ');
        MarkovWordOne markovWord = new MarkovWordOne();
        runModel(markovWord, st, 200);
    }

    public void runMarkovTwo(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWordTwo markovWord2 = new MarkovWordTwo();
        runModel(markovWord2, st, 120, 832);
    }

    public void runMarkovWord(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWord mw = new MarkovWord(5);
        runModel(mw, st,120,844);
    }

    public void testHashMap(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        EfficientMarkovWord mw = new EfficientMarkovWord (2);
        runModel(mw, st,50,65);
    }

    public void compareMethods(){
        MarkovWord markovModel2 = new MarkovWord(2);
        EfficientMarkovWord efficientMarkovModel2 = new EfficientMarkovWord(2);

        FileResource fr = new FileResource("com/dukeCourse4/data/hawthorne.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 100;
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
