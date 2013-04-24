package com.crypto;

public class Digraph {

    private char firstLetter;
    private Coordinate firstCoordinate;
    private char secondLetter;
    private Coordinate secondCoordinate;

    public Coordinate getFirstCoordinate() {
        return firstCoordinate;
    }

    public void setFirstCoordinate(Coordinate firstCoordinate) {
        this.firstCoordinate = firstCoordinate;
    }

    public Coordinate getSecondCoordinate() {
        return secondCoordinate;
    }

    public void setSecondCoordinate(Coordinate secondCoordinate) {
        this.secondCoordinate = secondCoordinate;
    }

    public char getSecondLetter() {
        return secondLetter;
    }

    public void setSecondLetter(char secondLetter) {
        this.secondLetter = secondLetter;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(char firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String toString(){
        return Character.toString(firstLetter) + Character.toString(secondLetter);
    }
}
