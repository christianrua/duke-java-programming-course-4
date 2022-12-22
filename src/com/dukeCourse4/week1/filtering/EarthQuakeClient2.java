package com.dukeCourse4.week1.filtering;

import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class EarthQuakeClient2 {
    private String nov20QuakeDataPath = "src/com/dukeCourse4/data/nov20quakedata.atom";

    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> getQuakeData(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = nov20QuakeDataPath;
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        return list;
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) {
            if (f.satisfies(qe)) {
                answer.add(qe);
            }
        }

        return answer;
    }

    public void quakesWithFilter() {
        ArrayList<QuakeEntry> list = getQuakeData();

        Filter magnitudeFilter = new MagnitudeFilter(3.5,4.5, "magnitudeFilter");
        Filter depthFilter = new DepthFilter(-55000.0, -20000.0, "depthFilter");

        ArrayList<QuakeEntry> filteredByMagnitude = filter(list, magnitudeFilter);
        ArrayList<QuakeEntry> filteredByDepthAndMagnitude = filter(filteredByMagnitude, depthFilter);
        System.out.println("The number of earthquakes found is " + filteredByDepthAndMagnitude.size());
        for (QuakeEntry qe: filteredByDepthAndMagnitude) {
            System.out.println(qe);
        }

//        Location denver = new Location(39.7392, -104.9903);
//        DistanceFilter distanceFilter = new DistanceFilter(denver,1000000, "distanceFilter");
//        PhraseFilter phraseFilter = new PhraseFilter("end", "a", "phraseFilter");
//
//        ArrayList<QuakeEntry> filteredPhrase = filter(list, phraseFilter);
//        ArrayList<QuakeEntry> filteredPhraseAndDistance = filter(filteredPhrase, distanceFilter);
//        System.out.println("The number of earthquakes found is " + filteredPhraseAndDistance.size());
//        for (QuakeEntry qe: filteredPhraseAndDistance) {
//            System.out.println(qe);
//        }

    }

    public void testMatchAllFilter(){
        ArrayList<QuakeEntry> list = getQuakeData();

        MatchAllFilter maf = new MatchAllFilter();

        Filter magnitudeFilter = new MagnitudeFilter(1.0,4.0, "magnitudeFilter");
        Filter depthFilter = new DepthFilter(-180000.0, -30000.0, "depthFilter");
        PhraseFilter phraseFilter = new PhraseFilter("any", "o", "phraseFilter");

        maf.addFilter(magnitudeFilter);
        maf.addFilter(depthFilter);
        maf.addFilter(phraseFilter);

        ArrayList<QuakeEntry> filteredData = filter(list, maf);

        for (QuakeEntry qe: filteredData) {
            System.out.println(qe);
        }

        System.out.println("the amount of earthquakes are " + filteredData.size());
        System.out.println("Filters used are: " + maf.getName());


    }

    public void testMatchAllFilter2(){
        ArrayList<QuakeEntry> list = getQuakeData();

        MatchAllFilter maf = new MatchAllFilter();

        Filter magnitudeFilter = new MagnitudeFilter(0.0,5.0, "magnitudeFilter");
        Location billund = new Location(55.7308,9.1153);
        Filter distanceFilter = new DistanceFilter(billund, 3000000, "distanceFilter");
        PhraseFilter phraseFilter = new PhraseFilter("any", "e", "phraseFilter");

        maf.addFilter(magnitudeFilter);
        maf.addFilter(distanceFilter);
        maf.addFilter(phraseFilter);

        ArrayList<QuakeEntry> filteredData = filter(list, maf);

        for (QuakeEntry qe: filteredData) {
            System.out.println(qe);
        }

        System.out.println("the amount of earthquakes are " + filteredData.size());
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                    qe.getLocation().getLatitude(),
                    qe.getLocation().getLongitude(),
                    qe.getMagnitude(),
                    qe.getInfo());
        }
    }
}
