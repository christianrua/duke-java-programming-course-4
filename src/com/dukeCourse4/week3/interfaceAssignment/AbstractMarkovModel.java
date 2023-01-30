package com.dukeCourse4.week3.interfaceAssignment;

/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;

    public AbstractMarkovModel() {
        myRandom = new Random();
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    abstract public String getRandomText(int numChars);

    protected ArrayList<String> getFollows(String letters){
        int lettersLength = letters.length();
        ArrayList<String> follows = new ArrayList<>();
        int trainingTextLength = myText.length();

        for(int i=0; i < trainingTextLength; i++){
            int substringMagnitude = i+ lettersLength;
            if(substringMagnitude < trainingTextLength){
                String currentLetters = myText.substring(i,substringMagnitude);
                int nextIndex = i + 1;
                if(lettersLength != 1){
                    nextIndex = i + lettersLength ;
                }
                if(letters.equals(currentLetters) && nextIndex < trainingTextLength){
                    follows.add(Character.toString(myText.charAt(nextIndex)));
                }
            }
        }
        return follows;
    }

}
