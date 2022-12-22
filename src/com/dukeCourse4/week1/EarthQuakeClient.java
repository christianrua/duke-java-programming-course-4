package com.dukeCourse4.week1;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class EarthQuakeClient {

    private String nov20QuakeDataPath = "src/com/dukeCourse4/data/nov20quakedata.atom";

    public ArrayList<QuakeEntry> getQuakeData(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = nov20QuakeDataPath;
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size() + " quakes");
        return list;
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData, double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for (QuakeEntry qe : quakeData) {
            if (qe.getMagnitude() > magMin) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData, double distMax, Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();

        for (QuakeEntry qe : quakeData) {
            if (qe.getLocation().distanceTo(from) < distMax) {
                answer.add(qe);
            }
        }
        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                    qe.getLocation().getLatitude(),
                    qe.getLocation().getLongitude(),
                    qe.getMagnitude(),
                    qe.getInfo());
        }

    }

    public void bigQuakes() {
        ArrayList<QuakeEntry> list = getQuakeData();

        ArrayList<QuakeEntry> listBig = filterByMagnitude(list, 5.0);
        for (QuakeEntry qe : listBig) {
            System.out.println(qe);
        }
    }

    public void createCSV(){
        ArrayList<QuakeEntry> list = getQuakeData();
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }

    public void closeToMe() {
        ArrayList<QuakeEntry> list = getQuakeData();;

        //Durham, NC
        //Location city = new Location(35.988, -78.907);
        //Bridgeport, CA
        Location city = new Location(38.17, -118.82);
        ArrayList<QuakeEntry> close = filterByDistanceFrom(list, 1000*1000, city);
        for (int k=0; k< close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = city.distanceTo(entry.getLocation());
            System.out.println(distanceInMeters/1000 + " " + entry.getInfo());
        }
    }

    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData, double minDepth, double maxDepth){
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (QuakeEntry qe : quakeData) {
            double depth = qe.getDepth();
            if (depth > minDepth && depth < maxDepth) {
                answer.add(qe);
            }
        }

        return answer;
    }

    public void quakesOfDepth(){
        ArrayList<QuakeEntry> list = getQuakeData();
        ArrayList<QuakeEntry> filteredQuakes = filterByDepth(list, -4000.0, -2000.0);
        System.out.println("Find quakes with depth between -8000.0 and -5000.0");
        System.out.println("Found " + filteredQuakes.size() + " quakes that match that criteria");
        for (QuakeEntry qe : filteredQuakes) {
            System.out.println(qe);
        }
    }

    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData, String where, String phrase){
        ArrayList<QuakeEntry> answer = new ArrayList<>();
        for (QuakeEntry qe : quakeData) {
            String info = qe.getInfo();
            switch (where){

                case "start":
                    if(info.startsWith(phrase)){
                        answer.add(qe);
                    }
                    break;

                case "end":
                    if(info.endsWith(phrase)){
                        answer.add(qe);
                    }
                    break;

                case "any":
                    if(info.contains(phrase)){
                        answer.add(qe);
                    }
                    break;
            }
        }
        return answer;
    }

    public void quakesByPhrase(){
        ArrayList<QuakeEntry> list = getQuakeData();
        ArrayList<QuakeEntry> quakesByPhraseList = filterByPhrase(list,"any", "Can");
        System.out.println("The total number of earth quakes are " + quakesByPhraseList.size());
        System.out.println("list content ");
        for(QuakeEntry qe : quakesByPhraseList){
            System.out.println(qe.toString());
        }
    }
}
