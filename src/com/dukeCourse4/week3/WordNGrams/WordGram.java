package com.dukeCourse4.week3.WordNGrams;

public class WordGram {

    private String[] myWords;
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        for(int k=0; k < myWords.length;k++){
            ret += myWords[k] + " ";
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if(this.length() != other.length()){
            return false;
        }

        for(int k = 0; k < this.length();k++){
            if(!myWords[k].equals(other.wordAt(k))){
                return false;
            }
        }
        return true;
    }

    public WordGram shiftAdd(String word) {
        String[] helper = new String[myWords.length];
        for(int k=0; k < myWords.length; k++){
            if(k == myWords.length - 1){
                helper[k] = word;
            } else {
                helper[k] = this.wordAt(k+1);
            }
        }

        WordGram out = new WordGram(helper, 0, myWords.length);
        // shift all words one towards 0 and add word at the end.
        // you lose the first word
        return out;
    }
}
