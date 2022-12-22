package com.dukeCourse4.week1;

import java.util.*;
import com.dukeCourse4.week1.EarthQuakeClient;

public class LargestQuakes {

    private EarthQuakeClient eqc = new EarthQuakeClient();

    public void findLargestQuakes(){
        ArrayList<QuakeEntry> list = eqc.getQuakeData();
        ArrayList<QuakeEntry> largestQuakesList = getLargest(list, 50);
        for(QuakeEntry qe : largestQuakesList){
            System.out.println(qe.toString());
        }
//        System.out.println("total amount of earth quakes " + list.size());
//        for(QuakeEntry qe : list){
//            System.out.println(qe.toString());
//        }
//        int index = indexOfLargest(list);
//        System.out.println("The largest earth quake index is " + index);
//        System.out.println("largest earth quake content " + list.get(index).toString());
    }

    public int indexOfLargest(ArrayList<QuakeEntry> data){
        int indexBiggestMagnitude = 0;
        double biggestMagnitude = 0;

        for(QuakeEntry qe : data){
            if(qe.getMagnitude() > biggestMagnitude){
                biggestMagnitude = qe.getMagnitude();
                indexBiggestMagnitude =  data.indexOf(qe);
            }
        }
        return indexBiggestMagnitude;
    }
    // I'm here writing the method getLargest

    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> list = eqc.getQuakeData();
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        Collections.sort(list, QuakeEntry.sortByMagnitude);
        if(list.size() < howMany){
            return list;
        } else {
            for(int i=0; i < howMany; i++){
                answer.add(list.get(i));
            }
            return answer;
        }
    }


}
