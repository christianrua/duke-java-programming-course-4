package com.dukeCourse4.week1.filtering;

public class DepthFilter implements Filter {

    private double minDepth, maxDepth;
    private String filterName;

    public DepthFilter(double minDepthParam, double maxDepthParam, String givenFilterName){
        minDepth =  minDepthParam;
        maxDepth = maxDepthParam;
        filterName = givenFilterName;
    }

    public  boolean satisfies(QuakeEntry qe){
        double magValue = qe.getDepth();
        if(magValue >= minDepth && magValue <= maxDepth){
            return true;
        } else {
            return false;
        }
    }

    public String getName(){
        return filterName;
    }

}
