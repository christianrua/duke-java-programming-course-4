package com.dukeCourse4.week1;
import com.dukeCourse4.week1.*;

public class test {

    public static void main(String[] args) {
        EarthQuakeClient eqc = new EarthQuakeClient();
        ClosestQuakes cq = new ClosestQuakes();
        //eqc.bigQuakes();
        cq.findClosestQuakes();
    }
}
