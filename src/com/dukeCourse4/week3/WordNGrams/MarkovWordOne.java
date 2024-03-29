package com.dukeCourse4.week3.WordNGrams;

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;

    public MarkovWordOne() {
        myRandom = new Random();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }

        return sb.toString().trim();
    }

    private int indexOf(String[] words, String target, int start){
        for(int i=start; i < words.length; i++){
            if(target.equals(words[i])){
                return i;
            }

        }
        return -1;
    }

    private ArrayList<String> getFollows(String key) {
        ArrayList<String> follows = new ArrayList<>();
        int pos = 0;
        while (pos < myText.length){
            int start = indexOf(myText, key, pos);
            if(start == -1){
                break;
            }
            if(start + 1 >= myText.length - 1){
                break;
            }
            String next = myText[start+1];
            follows.add(next);
            pos = start + 2;
        }
        return follows;
    }

    public void testIndexOf(){
        String[] testArray = "this is just a test yes this is a simple test".split("\\s+");
        int response = indexOf(testArray,"this",0);
        System.out.println("index of 'this' starting at 0: " + response);
        response = indexOf(testArray,"this",3);
        System.out.println("index of 'this' starting at 3: " + response);
        response = indexOf(testArray,"frog",0);
        System.out.println("index of 'frog' starting at 0: " + response);
        response = indexOf(testArray,"frog",5);
        System.out.println("index of 'frog' starting at 5: " + response);
        response = indexOf(testArray,"simple",2);
        System.out.println("index of 'simple' starting at 2: " + response);
        response = indexOf(testArray,"test",5);
        System.out.println("index of 'test' starting at 5: " + response);
    }
}
