package com.dukeCourse4.week1.filtering;

import java.util.ArrayList;

public class MatchAllFilter implements Filter {
    private ArrayList<Filter> filtersList;

    public MatchAllFilter(){
        filtersList = new ArrayList<>();
    }

    public void addFilter(Filter filter){
        filtersList.add(filter);
    }

    public  boolean satisfies(QuakeEntry qe){
        for(Filter f : filtersList){
            if(!f.satisfies(qe)){
                return false;
            }
        }

        return true;
    }

    public String getName(){
        String filtersNames = "";
        for(Filter f : filtersList){
            if(filtersNames==""){
                filtersNames = f.getName();
            } else {
                filtersNames = filtersNames + ", " + f.getName();
            }

        }
        return filtersNames;
    }
}
