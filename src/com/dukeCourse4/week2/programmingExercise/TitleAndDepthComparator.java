package com.dukeCourse4.week2.programmingExercise;

import java.util.Comparator;

public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2){
        int result = q1.getInfo().compareTo(q2.getInfo());
        if(result == 0){
            if(q1.getDepth() < q2.getDepth()){
                return -1;
            }
            if(q1.getDepth() > q2.getDepth()){
                return 1;
            }
            return 0;
        }
        return result;
    }


}
