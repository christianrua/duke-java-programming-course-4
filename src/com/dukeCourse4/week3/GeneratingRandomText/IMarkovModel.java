package com.dukeCourse4.week3.GeneratingRandomText;

public interface IMarkovModel {
    public void setTraining(String text);
    public String getRandomText(int numChars);
}
