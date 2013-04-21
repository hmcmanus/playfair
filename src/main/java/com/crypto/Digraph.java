package com.crypto;

public class Digraph {

    private char firstLetter;
    private int firstLetterI;
    private int firstLetterJ;

    private char secondLetter;
    private int secondLetterI;
    private int secondLetterJ;

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

    public int getFirstLetterI() {
        return firstLetterI;
    }

    public void setFirstLetterI(int firstLetterI) {
        this.firstLetterI = firstLetterI;
    }

    public int getFirstLetterJ() {
        return firstLetterJ;
    }

    public void setFirstLetterJ(int firstLetterJ) {
        this.firstLetterJ = firstLetterJ;
    }

    public int getSecondLetterI() {
        return secondLetterI;
    }

    public void setSecondLetterI(int secondLetterI) {
        this.secondLetterI = secondLetterI;
    }

    public int getSecondLetterJ() {
        return secondLetterJ;
    }

    public void setSecondLetterJ(int secondLetterJ) {
        this.secondLetterJ = secondLetterJ;
    }
}
