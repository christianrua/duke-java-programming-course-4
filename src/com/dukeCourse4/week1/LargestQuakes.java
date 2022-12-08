package com.dukeCourse4.week1;

import java.util.*;
import com.dukeCourse4.week1.EarthQuakeClient;

public class LargestQuakes {

    private EarthQuakeClient eqc = new EarthQuakeClient();

    public void findLargestQuakes(){
        ArrayList<QuakeEntry> list = eqc.getQuakeData();
        System.out.println("total amount of earth quakes " + list.size());
        for(QuakeEntry qe : list){
            System.out.println(qe.toString());
        }
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
    public static Comparator<QuakeEntry> comparator = new Comparator<QuakeEntry>() {
        @Override
        public int compare(QuakeEntry o1, QuakeEntry o2) {
            return (int)(o1.getMagnitude() - o2.getMagnitude());
        }
    }

    public void getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> list = eqc.getQuakeData();
        Collections.sort(list, QuakeEntry.);
    }
}
