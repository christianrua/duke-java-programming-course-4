package com.dukeCourse4.week3.WordNGrams;

public interface IMarkovModel {
    public void setTraining(String text);

    public void setRandom(int seed);

    public String getRandomText(int numChars);
}
