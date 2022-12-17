package com.dukeCourse4.week1.filtering;

public class DistanceFilter implements Filter {
    private Location location;
    private float maxDistance;

    public DistanceFilter(Location givenLocation, float givenDistance){
        location = givenLocation;
        maxDistance = givenDistance;
    }

    public  boolean satisfies(QuakeEntry qe){
        // Currently I'm working on this filter.
        double magValue = qe.getMagnitude();
        if(magValue >= minMag && magValue <= maxMag){
            return true;
        } else {
            return false;
        }
    }
}
