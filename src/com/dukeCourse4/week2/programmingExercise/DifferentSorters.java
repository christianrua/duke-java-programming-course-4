package com.dukeCourse4.week2.programmingExercise;

import java.util.*;
import edu.duke.*;
import com.dukeCourse4.week2.programmingExercise.MagnitudeComparator;
import com.dukeCourse4.week2.programmingExercise.DistanceComparator;
import com.dukeCourse4.week2.programmingExercise.TitleAndDepthComparator;
import com.dukeCourse4.week2.programmingExercise.TitleLastAndMagnitudeComparator;

public class DifferentSorters {

    private String dataUrl = "src/com/dukeCourse4/data/nov20quakedata.atom";

    private ArrayList<QuakeEntry> getDataList(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = dataUrl;
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        return list;
    }

    public void sortWithCompareTo() {
        ArrayList<QuakeEntry> list  = getDataList();
        Collections.sort(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

        int quakeNumber = 10;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));

    }

    public void sortByMagnitude() {
        ArrayList<QuakeEntry> list  = getDataList();
        Collections.sort(list, new MagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByDistance() {
        ArrayList<QuakeEntry> list  = getDataList();
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByTitleAndDepth(){
        ArrayList<QuakeEntry> list  = getDataList();
        Collections.sort(list, new TitleAndDepthComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

        int quakeNumber = 10;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

    public void sortByLastWordInTitleThenByMagnitude(){
        ArrayList<QuakeEntry> list  = getDataList();
        Collections.sort(list, new TitleLastAndMagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

        int quakeNumber = 10;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

}
