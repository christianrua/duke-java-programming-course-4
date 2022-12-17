package com.dukeCourse4.week1.filtering;

public class MagnitudeFilter implements Filter {

    private double minMag, maxMag;

    public MagnitudeFilter(double minMagParam,double maxMagParam){
        minMag = minMagParam;
        maxMag = maxMagParam;
    }

    public  boolean satisfies(QuakeEntry qe){
        double magValue = qe.getMagnitude();
        if(magValue >= minMag && magValue <= maxMag){
            return true;
        } else {
            return false;
        }
    }

}
