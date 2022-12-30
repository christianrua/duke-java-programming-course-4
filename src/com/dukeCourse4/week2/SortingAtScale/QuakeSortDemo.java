package com.dukeCourse4.week2.SortingAtScale;

import edu.duke.*;
import java.util.*;

public class QuakeSortDemo {
    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "src/com/dukeCourse4/data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";

        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);

        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }
    }
}
