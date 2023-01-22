package com.dukeCourse4.week3.GeneratingRandomText;

import java.util.ArrayList;
import java.util.Random;

public class BaseMarkov {
//    private double varDouble;
//    public static final int CONSTANT = 0;
//    public abstract void publicMethod();
//    public void setVarDouble(double var) {
//        this.varDouble = var;
//    }
//    public double getVarDouble() {
//        return varDouble;
//    }

    private String trainingText;
    private Random myRandom;
    private Integer markovLevel;

    public BaseMarkov(Integer markovLevelInput){
        markovLevel = markovLevelInput;
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        trainingText = s.trim();
    }

    private Integer getKeyUpperLevel(String key, Integer start){
        return start+key.length()+1;
    }

    private Integer getStart(String key, Integer pos){
        return trainingText.indexOf(key, pos);
    }

    public ArrayList<String> getFollows(String letters){
        int lettersLength = letters.length();
        ArrayList<String> follows = new ArrayList<>();
        int trainingTextLength = trainingText.length();

        for(int i=0; i < trainingTextLength; i++){
            int substringMagnitude = i+ lettersLength;
            if(substringMagnitude < trainingTextLength){
                String currentLetters = trainingText.substring(i,substringMagnitude);
                int nextIndex = i + 1;
                if(lettersLength != 1){
                    nextIndex = i + lettersLength ;
                }

                if(letters.equals(currentLetters) && nextIndex < trainingTextLength){
                    follows.add(Character.toString(trainingText.charAt(nextIndex)));
                }
            }

        }
        return follows;
    }
//    public ArrayList<String> getFollows(String key){
//        ArrayList<String> follows = new ArrayList<String>();
//        int pos = 0;
//        int trainingLength = trainingText.length();
//        int start = getStart(key, pos);
//        int upperLimit = getKeyUpperLevel(key, start);
//        while (pos < trainingLength && upperLimit <= trainingLength){
//
//            if(start == -1){
//                break;
//            }
//
//            String next = trainingText.substring(start+key.length(), start+key.length()+1);
//            follows.add(next);
//            pos = start+key.length();
//            upperLimit = getKeyUpperLevel(key, start);
//            start = getStart(key, pos);
//
//            if(start + key.length() >= trainingText.length()-1){
//                break;
//            }
//        }
//
//        return follows;
//    }

    public String getRandomText(int numChars){

        if (trainingText == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        if(this.markovLevel == 0){
            for(int k=0; k < numChars; k++){
                int index = myRandom.nextInt(trainingText.length());
                sb.append(trainingText.charAt(index));
            }
            return sb.toString();
        } else {
            int index = myRandom.nextInt(trainingText.length() - this.markovLevel);
            String key =  trainingText.substring(index, index + this.markovLevel);
            sb.append(key);

            for(int k=0; k < numChars - this.markovLevel; k++){
                ArrayList<String> follows = getFollows(key);

                int followsListSize = follows.size();
                if(followsListSize ==0){
                    break;
                }

                index = myRandom.nextInt(followsListSize);
                String next = follows.get(index);
                sb.append(next);
                key = key.substring(1) + next;
            }
            return sb.toString();
        }

    }
}
