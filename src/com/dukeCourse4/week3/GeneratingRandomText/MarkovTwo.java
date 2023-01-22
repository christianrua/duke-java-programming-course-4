package com.dukeCourse4.week3.GeneratingRandomText;

import java.util.*;

public class MarkovTwo {

    private String trainingText;
    private Random myRandom;

    public MarkovTwo() {
        myRandom = new Random();
    }

    public void setRandom(int seed){
        myRandom = new Random(seed);
    }

    public void setTraining(String s){
        trainingText = s.trim();
    }

//    public ArrayList<String> getFollows(String letters){
//        ArrayList<String> follows = new ArrayList<String>();
//        int trainingTextLength = trainingText.length();
//        for(int i=0; i < trainingTextLength; i++){
//            int substringMagnitude = i+letters.length();
//            if(substringMagnitude < trainingTextLength){
//                String currentLetters = trainingText.substring(i,substringMagnitude);
//                int nextIndex = i + 1;
//                if(letters.equals(currentLetters) && nextIndex < trainingTextLength){
//                    follows.add(Character.toString(trainingText.charAt(nextIndex)));
//                }
//            }
//
//        }
//        return follows;
//    }

    private ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<String>();
        int pos = 0;
        while (pos < trainingText.length()){
            int start = trainingText.indexOf(key, pos);
            if(start == -1){
                break;
            }
            if(start + key.length() >= trainingText.length()-1){
                break;
            }
            String next = trainingText.substring(start+key.length(), start+key.length()+1);
            follows.add(next);
            pos = start+key.length();
        }

        return follows;
    }

    public String getRandomText(int numChars){
        if (trainingText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(trainingText.length()-2);
        String key =  trainingText.substring(index, index+2);
        sb.append(key);

        for(int k=0; k < numChars-2; k++){
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
