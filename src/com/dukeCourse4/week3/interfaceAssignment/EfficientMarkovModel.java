package com.dukeCourse4.week3.interfaceAssignment;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EfficientMarkovModel extends AbstractMarkovModel {

    private int myOrder;
    private HashMap<String, ArrayList<String>> followsMap;
    private HashMap<String, Integer> followsSize;

    public EfficientMarkovModel(int order){
        myOrder = order;
        followsMap = new HashMap<>();
        followsSize = new HashMap<>();
    }

    public void setTraining(String s){
        myText = s.trim();
        buildHasMap();
        printHashMapInfo();
    }

    public void buildHasMap(){
        for(int i=0; i < myText.length() - myOrder + 1;i++){
            String key = myText.substring(i, i+ this.myOrder);
            if(!followsMap.containsKey(key)){
                ArrayList<String> result = getFollows(key);
                followsMap.put(key, result);
                followsSize.put(key, result.size());
            }
        }

    }

    public void printHashMapInfo(){
        System.out.println("followsHashMap content...");
        System.out.println("keys and values...");
        for (String i : followsMap.keySet()) {
            System.out.println("key: " + i + " value: " + followsMap.get(i));
        }

        System.out.println("Number of keys in the map " + followsMap.size());
        //OptionalInt biggestSizeArray = followsMap.values().parallelStream().mapToInt(b -> b.size()).max();
        int biggestSizeArray = Collections.max(followsSize.values());
        System.out.println("The size of the biggest follows list is " + biggestSizeArray);
        System.out.println("the keys with this size are: ");
        for(String keyValue : followsSize.keySet()){
            if(biggestSizeArray == followsSize.get(keyValue)){
                System.out.println(keyValue);
            }
        }
    }

    public ArrayList<String> getFollowsFromHashMap(String key){
        return followsMap.get(key);
    }

    public String getRandomText(int numChars){

        if (myText == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        if(this.myOrder == 0){
            for(int k=0; k < numChars; k++){
                int index = myRandom.nextInt(myText.length());
                sb.append(myText.charAt(index));
            }
            return sb.toString();
        } else {
            int index = myRandom.nextInt(myText.length() - this.myOrder);
            String key =  myText.substring(index, index + this.myOrder);
            sb.append(key);

            for(int k=0; k < numChars - this.myOrder; k++){
                ArrayList<String> follows = getFollowsFromHashMap(key);

                int followsListSize = follows.size();
                if(followsListSize ==0){
                    break;
                }

                index = myRandom.nextInt(followsListSize);
                String next = follows.get(index);
                sb.append(next);
                //key = key.substring(1) + next;
                key = key.substring(key.length() - (this.myOrder - 1)) + next;
            }
            return sb.toString();
        }

    }

    public String toString(){
        return "EfficientMarkovModel of order " + myOrder;
    }

}
