package com.dukeCourse4.week1.filtering;

public class MagnitudeFilter implements Filter {

    private double minMag, maxMag;
    private String filterName;

    public MagnitudeFilter(double minMagParam,double maxMagParam, String givenFilterName){
        minMag = minMagParam;
        maxMag = maxMagParam;
        filterName = givenFilterName;
    }

    public  boolean satisfies(QuakeEntry qe){
        double magValue = qe.getMagnitude();
        if(magValue >= minMag && magValue <= maxMag){
            return true;
        } else {
            return false;
        }
    }

    public String getName(){
        return filterName;
    }

}
