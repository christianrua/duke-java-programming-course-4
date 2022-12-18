package com.dukeCourse4.week1.filtering;

public class PhraseFilter implements Filter {
    private String whereToSearch,phraseToSearch, filterName;

    public PhraseFilter(String where, String phrase, String givenFilterName){
        whereToSearch = where;
        phraseToSearch = phrase;
        filterName = givenFilterName;
    }

    public  boolean satisfies(QuakeEntry qe){
        String info = qe.getInfo();
        boolean answer = false;
        switch (whereToSearch){
            case "start":
                if(info.startsWith(phraseToSearch)){
                    answer = true;
                }
                break;

            case "end":
                if(info.endsWith(phraseToSearch)){
                    answer = true;
                }
                break;

            case "any":
                if(info.contains(phraseToSearch)){
                    answer = true;
                    }
                break;
        }

        return answer;
    }

    public String getName(){
        return filterName;
    }
}
