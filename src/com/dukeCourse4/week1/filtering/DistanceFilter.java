package com.dukeCourse4.week1.filtering;

public class DistanceFilter implements Filter {
    private Location location;
    private float maxDistance;
    private String filterName;

    public DistanceFilter(Location givenLocation, float givenDistance, String givenFilterName){
        location = givenLocation;
        maxDistance = givenDistance;
        filterName = givenFilterName;
    }

    public  boolean satisfies(QuakeEntry qe){

        if(location.distanceTo(qe.getLocation()) < maxDistance){
            return true;
        } else {
            return false;
        }
    }

    public String getName(){
        return filterName;
    }
}
