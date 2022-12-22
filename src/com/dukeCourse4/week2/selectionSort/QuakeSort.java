package com.dukeCourse4.week2.selectionSort;

import java.util.*;

public class QuakeSort {
//    public QuakeEntry getSmallestMagnitude(ArrayList<QuakeEntry> quakes) {
//        QuakeEntry min = quakes.get(0);
//        for(QuakeEntry q: quakes) {
//            if (q.getMagnitude() < min.getMagnitude()) {
//                min = q;
//            }
//        }
//        return min;
//    }

//    public ArrayList<QuakeEntry> sortByMagnitude(ArrayList<QuakeEntry> in) {
//        //out starts as empty ArrayList
//        ArrayList<QuakeEntry> out = new ArrayList<QuakeEntry>();
//        //As long as in is not empty
//        while(!in.isEmpty()) {
//            //Find smallest element in in (minElement)
//            QuakeEntry minElement = getSmallestMagnitude(in);
//            //Remove minElement from in
//            in.remove(minElement);
//            //Add minElement to out
//            out.add(minElement);
//        }
//        //out is the answer
//        return out;
//    }

    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i = from +1; i < quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
        //count from 0 to < in.size()
        for(int i = 0; i < in.size(); i++) {
            /* find the index of the smallest quake*/
            int minIdx = getSmallestMagnitude(in, i);
            /* swap the ith quake with the minIdxth quake */
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i, qmin);
            in.set(minIdx, qi);
        }
    }

    /* tester method to use in BlueJ */
    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "src/com/dukeCourse4/data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //list = sortByMagnitude(list);
        sortByMagnitude(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
}
