package com.dukeCourse4.week2.selectionSort;

import com.dukeCourse4.week1.Location;

import java.util.Comparator;

public class QuakeEntry implements Comparable<QuakeEntry>{

    private com.dukeCourse4.week1.Location myLocation;
    private String title;
    private double depth;
    private double magnitude;

    public QuakeEntry(double lat, double lon, double mag,
                      String t, double d) {
        myLocation = new com.dukeCourse4.week1.Location(lat,lon);

        magnitude = mag;
        title = t;
        depth = d;
    }

    public Location getLocation(){
        return myLocation;
    }

    public double getMagnitude(){
        return magnitude;
    }

    public String getInfo(){
        return title;
    }

    public double getDepth(){
        return depth;
    }

    @Override
    public int compareTo(QuakeEntry loc) {
        double difflat = myLocation.getLatitude() - loc.myLocation.getLatitude();
        if (Math.abs(difflat) < 0.001) {
            double diff = myLocation.getLongitude() - loc.myLocation.getLongitude();
            if (diff < 0) return -1;
            if (diff > 0) return 1;
            return 0;
        }
        if (difflat < 0) return -1;
        if (difflat > 0) return 1;

        // never reached
        return 0;
    }

    public static Comparator<QuakeEntry> sortByMagnitude = new Comparator<QuakeEntry>() {
        @Override
        public int compare(QuakeEntry o1, QuakeEntry o2) {
            return (int)(o2.getMagnitude()*100 - o1.getMagnitude()*100);
        }
    };

    public String toString(){
        return String.format("(%3.2f, %3.2f), mag = %3.2f, depth = %3.2f, title = %s", myLocation.getLatitude(),myLocation.getLongitude(),magnitude,depth,title);
    }
}


