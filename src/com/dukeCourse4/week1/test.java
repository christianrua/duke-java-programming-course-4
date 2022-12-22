package com.dukeCourse4.week1;
import com.dukeCourse4.week1.*;

public class test {

    public static void main(String[] args) {
        EarthQuakeClient eqc = new EarthQuakeClient();
        ClosestQuakes cq = new ClosestQuakes();
        LargestQuakes lq = new LargestQuakes();
        //eqc.quakesOfDepth();
        //eqc.quakesByPhrase();
        //cq.findClosestQuakes();
        lq.findLargestQuakes();
    }
}
