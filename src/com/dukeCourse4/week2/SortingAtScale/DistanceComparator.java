package com.dukeCourse4.week2.SortingAtScale;

import java.util.*;
import com.dukeCourse4.week1.Location;

public class DistanceComparator implements Comparator<QuakeEntry> {
    Location fromWhere;

    public DistanceComparator(Location where) {
        fromWhere = where;
    }

    public int compare(QuakeEntry q1, QuakeEntry q2) {
        double dist1 = q1.getLocation().distanceTo(fromWhere);
        double dist2 = q2.getLocation().distanceTo(fromWhere);
        return Double.compare(dist1, dist2);
    }
}
