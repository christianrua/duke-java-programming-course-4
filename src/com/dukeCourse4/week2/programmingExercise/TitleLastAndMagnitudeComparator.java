package com.dukeCourse4.week2.programmingExercise;

import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry q1, QuakeEntry q2){

        String[] q1Split = q1.getInfo().split("\\s");
        String[] q2Split = q2.getInfo().split("\\s");

        String q1LastWord = q1Split[q1Split.length - 1];
        String q2LastWord = q2Split[q2Split.length - 1];

        int result = q1LastWord.compareTo(q2LastWord);
        if(result == 0){
            if(q1.getMagnitude() < q2.getMagnitude()){
                return -1;
            }
            if(q1.getMagnitude() > q2.getMagnitude()){
                return 1;
            }
            return 0;
        }
        return result;
    }
}
