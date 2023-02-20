package com.dukeCourse4.week3.WordNGrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovWord implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    private int myOrder;
    private HashMap<WordGram,ArrayList<String>> followsHashMap;
    private HashMap<WordGram, Integer> followsSize;

    public EfficientMarkovWord(Integer order) {
        myRandom = new Random();
        myOrder = order;
        followsHashMap = new HashMap<>();
        followsSize = new HashMap<>();
    }

    public void buildMap(){

        for(int i=0; i < myText.length - myOrder + 1;i++){

            StringBuilder sb = new StringBuilder();
            String[] initialKeys = new String[myOrder];
            for(int k=0; k < myOrder; k++){
                initialKeys[k] = myText[i + k];
                sb.append(initialKeys[k]).append(" ");
            }
            WordGram key = new WordGram(initialKeys,0, initialKeys.length);

            ArrayList<String> follows = new ArrayList<>();

            int pos = 0;
            int kGramLength = key.length();
            while (pos < myText.length - kGramLength){
                int start = indexOf(myText, key, pos);
                if(start == -1){
                    break;
                }
                if(start + kGramLength >= myText.length ){
                    break;
                }
                follows.add(myText[start+kGramLength]);
                pos = start + kGramLength;
            }

            followsHashMap.put(key, follows);
            followsSize.put(key, follows.size());
        }

    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text){
        myText = text.split("\\s+");
        buildMap();
        printHashMapInfo();
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-myOrder);  // random word to start with
        String[] initialKeys = new String[myOrder];
        for(int k=0; k < myOrder; k++){
            initialKeys[k] = myText[index + k];
            sb.append(initialKeys[k]).append(" ");
        }
        WordGram key = new WordGram(initialKeys,0, initialKeys.length);

        for(int k=0; k < numWords-myOrder + 1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = key.shiftAdd(next);
        }

        return sb.toString().trim();
    }

    private int indexOf(String[] words, WordGram target, int start){
        for(int i=start; i < words.length - target.length(); i++){
            WordGram wg = new WordGram(words, i, target.length());
            if(wg.equals(target)){
                return i;
            }

        }
        return -1;
    }

    private ArrayList<String> getFollows(WordGram kGram) {
        return followsHashMap.get(kGram);
    }

    public void printHashMapInfo(){
        System.out.println("followsHashMap content...");
        System.out.println("keys and values...");
        for (WordGram i : followsHashMap.keySet()) {
            System.out.println("key: " + i.toString() + " value: " + followsHashMap.get(i));
        }

        System.out.println("Number of keys in the map " + followsHashMap.size());
        //OptionalInt biggestSizeArray = followsMap.values().parallelStream().mapToInt(b -> b.size()).max();
        int biggestSizeArray = Collections.max(followsSize.values());
        System.out.println("The size of the biggest follows list is " + biggestSizeArray);
        System.out.println("the keys with this size are: ");
        for(WordGram keyValue : followsSize.keySet()){
            if(biggestSizeArray == followsSize.get(keyValue)){
                System.out.println(keyValue);
            }
        }
    }
}
