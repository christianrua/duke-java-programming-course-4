package com.dukeCourse4.week3.interfaceAssignment;

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel extends AbstractMarkovModel {

    private int myOrder;

    public MarkovModel(int order){
        myOrder = order;
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

    public String toString(){
        return "MarkovModel of order " + myOrder;
    }

}
