package com.crypto;

import java.util.ArrayList;
import java.util.List;

public class Cipher {

    private String keyword;
    private char[][] table;

    /**
     * Constructs the cipher
     *
     * @param keyword Initialises the cipher
     */
    public Cipher(String keyword) {
        this.keyword = keyword;
        buildTable();
    }

    public String getKeyword() {
        return keyword;
    }

    public char[][] getTable() {
        return this.table;
    }

    private void buildTable(){
        char[] lettersInKeyword = keyword.toCharArray();
        List<Character> lettersInAlphabet = new ArrayList<Character>();
        lettersInAlphabet.add('A');
        lettersInAlphabet.add('B');
        lettersInAlphabet.add('C');
        lettersInAlphabet.add('D');
        lettersInAlphabet.add('E');
        lettersInAlphabet.add('F');
        lettersInAlphabet.add('G');
        lettersInAlphabet.add('H');
        lettersInAlphabet.add('I');
        lettersInAlphabet.add('K');
        lettersInAlphabet.add('L');
        lettersInAlphabet.add('M');
        lettersInAlphabet.add('N');
        lettersInAlphabet.add('O');
        lettersInAlphabet.add('P');
        lettersInAlphabet.add('Q');
        lettersInAlphabet.add('R');
        lettersInAlphabet.add('S');
        lettersInAlphabet.add('T');
        lettersInAlphabet.add('U');
        lettersInAlphabet.add('V');
        lettersInAlphabet.add('W');
        lettersInAlphabet.add('X');
        lettersInAlphabet.add('Y');
        lettersInAlphabet.add('Z');
        table = new char[5][5];
        for (char letter:lettersInKeyword) {
            addLetterToTable(letter);
            lettersInAlphabet.remove(Character.valueOf(letter));
        }

        for (char alphaLetter:lettersInAlphabet) {
            addLetterToTable(alphaLetter);
        }
    }

    private void addLetterToTable(char letter) {
        for (int i=0; i < 5; i++){
            for (int j=0;j<5;j++){
                if (table[i][j] == letter){
                    return;
                }
                if (table[i][j] == '\u0000'){
                    table[i][j] = letter;
                    return;
                }
            }
        }
    }
}
