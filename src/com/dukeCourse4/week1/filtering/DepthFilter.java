package com.dukeCourse4.week1.filtering;

public class DepthFilter implements Filter {

    private double minDepth, maxDepth;

    public DepthFilter(double minDepthParam, double maxDepthParam){
        minDepth =  minDepthParam;
        maxDepth = maxDepthParam;
    }

    public  boolean satisfies(QuakeEntry qe){
        double magValue = qe.getDepth();
        if(magValue >= minDepth && magValue <= maxDepth){
            return true;
        } else {
            return false;
        }
    }

}
