package com.dukeCourse4.week2.SortingAtScale;

import com.dukeCourse4.week1.Location;
import edu.duke.*;
import java.util.*;
import com.dukeCourse4.week2.SortingAtScale.DistanceComparator;

public class DistanceSorter {

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "src/com/dukeCourse4/data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        //You know what would be amazing?  If the Location class documented
        //whether east or west were positive!
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
}
