package com.dukeCourse4.week3.GeneratingRandomText;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractMarkovModel implements IMarkovModel{

    protected String myText;
    protected Random myRandom;

    public AbstractMarkovModel(){
        myRandom = new Random();
    }

    public void setTraining(String text){
        myText = text;
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
