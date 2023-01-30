package com.dukeCourse4.week3.GeneratingRandomText;

import java.util.ArrayList;

public class MarkovModel extends AbstractMarkovModel {

    private int myOrder;

    public MarkovModel(int order){
        myOrder = order;
    }

    public String getRandomText(int length){
        StringBuffer sb = new StringBuffer();
        int index = myRandom.nextInt(myText.length() - myOrder);
        String current = myText.substring(index, index + myOrder);
        sb.append(current);
        for(int k=0; k < length - myOrder; k++){
            ArrayList<String> follows = getFollows(current);
        }
        return sb.toString();
    }
}
