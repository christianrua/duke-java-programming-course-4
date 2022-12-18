package com.dukeCourse4.week1.filtering;
/**
 * Write a description of class MinMaxFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MinMagFilter implements Filter{
    private double magMin;
    private String filterName;

    public MinMagFilter(double min, String givenFilterName) {
        magMin = min;
        filterName = givenFilterName;
    }

    public boolean satisfies(QuakeEntry qe) {
        return qe.getMagnitude() >= magMin;
    }

    public String getName(){
        return filterName;
    }

}
