package com.dukeCourse4.week2.selectionSort;

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {

    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }

    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    public void sortByMagnitude(ArrayList<QuakeEntry> in) {

        for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }

    }

    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from){
        int maxDepthIndex = from;
        for(int i=from+1; i < quakeData.size(); i++){
            if(quakeData.get(i).getDepth() > quakeData.get(maxDepthIndex).getDepth()){
                maxDepthIndex = i;
            }
        }
        return maxDepthIndex;
    }

    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
        for (int i=0; i< in.size(); i++) {
        //for (int i=0; i< 51; i++) {
                int maxIdx = getLargestDepth(in,i);
                QuakeEntry qi = in.get(i);
                QuakeEntry qmax = in.get(maxIdx);
                in.set(i,qmax);
                in.set(maxIdx,qi);
            }
        }


    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData, int numSorted){
            for(int i=0; i < quakeData.size() - 1 - numSorted; i++){
                int nextIndex = i+1;
                if(nextIndex >= quakeData.size()){
                    break;
                } else {
                    QuakeEntry currentElem = quakeData.get(i);
                    QuakeEntry nextElem = quakeData.get(nextIndex);
                    if(currentElem.getMagnitude() > nextElem.getMagnitude()){
                        //System.out.println("making swapping with the current mag " + currentElem.getMagnitude() + ", and the next mag "+nextElem.getMagnitude());
                        quakeData.set(i, nextElem);
                        quakeData.set(nextIndex, currentElem);
                    }
                }

            }
    }

    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
//        System.out.println("content before run");
//        in.forEach(System.out::println);
//        System.out.println("\n");
        for(int i=0; i< in.size() - 1; ++i){
            onePassBubbleSort(in,i);
//            System.out.println("content after run number \n"+i);
//            in.forEach(System.out::println);
//            System.out.println("\n");
        }

    }

    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        for(int i=0; i<quakes.size() - 1; i++){
            if(quakes.get(i).getMagnitude() > quakes.get(i+1).getMagnitude()){
                return false;
            }
        }
        return true;
    }

    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
        for(int i=0; i< in.size() - 1; ++i){
            onePassBubbleSort(in,i);
            if(checkInSortedOrder(in)){
                System.out.println("number of runs needed to sort the list: " + (i+1));
                break;
            }
        }
    }

    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
        for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
            if(checkInSortedOrder(in)){
                System.out.println("number of runs needed to sort the list: " + (i+1));
                break;
            }
        }
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "src/com/dukeCourse4/data/nov20quakedatasmall.atom";
        String source = "src/com/dukeCourse4/data/earthQuakeDataDec6sample1.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);

        System.out.println("read data for "+list.size()+" quakes");
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
        //sortByMagnitudeWithCheck(list);
        for (QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                    qe.getLocation().getLatitude(),
                    qe.getLocation().getLongitude(),
                    qe.getMagnitude(),
                    qe.getInfo());
        }

    }
}
