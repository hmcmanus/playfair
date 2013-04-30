package com.crypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PlayFair
{
    private CypherMessage cypherMessage;
    private Cipher cipher;
    private Mode mode;
    private static final int MAX_I = 4;
    private static final int MAX_J = 4;
    private static final int MIN_I = 0;
    private static final int MIN_J = 0;

    public static void main(String[] args){
        PlayFair playFair = new PlayFair();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        System.out.println("Enter a keyword:");

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String input;
        try {
            playFair.setCipher(new Cipher(bufferedReader.readLine()));
        } catch (IOException ioe) {
            System.out.println("Invalid keyword");
        }

        try {
            while ( ! "EXIT".equals(input = bufferedReader.readLine()) ) {
                System.out.println("Enter a message to encrypt, EXIT to finish:");
                playFair.convertMessageToDigraphs(input);
                String outText = playFair.encrypt();
                if (null != outText) {
                    System.out.println(outText);
                }
            }
        } catch (IOException ioe) {
            System.out.println("An error has occurred");
        }
    }

    public List<Digraph> convertMessageToDigraphs(String message) {
        cypherMessage = new CypherMessage(message);
        return cypherMessage.toDigraphs();
    }

    public CypherMessage getCipherMessage() {
        return this.cypherMessage;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public String encrypt() {
        String encrpyted = "";
        // Have to go through each digraph and encrypt
        for (Digraph digraph:cypherMessage.getDigraphs()){
            encrpyted = encrpyted + processDigraph(digraph);
        }
        // TODO: Remove the extra X in the decrypted message
//        if (mode.equals(Mode.DECRYPT)) {
//            encrpyted = cypherMessage.stripExtraX(encrpyted);
//        }
        return encrpyted;
    }

    private String processDigraph(Digraph digraph) {
        digraph.setFirstCoordinate(cipher.getLetterCoordinateInTable(digraph.getFirstLetter()));
        digraph.setSecondCoordinate(cipher.getLetterCoordinateInTable(digraph.getSecondLetter()));
        Rule digraphRule = determineRule(digraph);
        return processRule(digraph, digraphRule);
    }

    private String processRule(Digraph digraph, Rule digraphRule) {
        String encryptedDigraph = "";
        switch (digraphRule) {
            case ROW: encryptedDigraph = encryptRowRule(digraph);
                break;
            case COLUMN: encryptedDigraph = encryptColumnRule(digraph);
                break;
            case RECTANGLE: encryptedDigraph = encyrptRectangleRule(digraph);
                break;
            default: // throw exception
        }
        return encryptedDigraph;
    }

    private String encyrptRectangleRule(Digraph digraph) {
        // Rectangle rule is when the digraph letters are in different columns and different rows in the table.
        // You take the opposing corners of the rectangle and get the letters there
        String encryptedDigraph = "" + cipher.getLetterAtCoordinate(
                determineFirstCoordinateForRectangleRule(digraph));

        encryptedDigraph = encryptedDigraph + cipher.getLetterAtCoordinate(
                determineSecondCoordinateForRectangleRule(digraph));
        return encryptedDigraph;
    }

    private Coordinate determineSecondCoordinateForRectangleRule(Digraph digraph) {
        Coordinate coordinateToRetrieve = new Coordinate();
        coordinateToRetrieve.setI(digraph.getSecondCoordinate().getI());
        coordinateToRetrieve.setJ(digraph.getFirstCoordinate().getJ());
        return coordinateToRetrieve;
    }

    private Coordinate determineFirstCoordinateForRectangleRule(Digraph digraph) {
        Coordinate coordinateToRetrieve = new Coordinate();
        coordinateToRetrieve.setI(digraph.getFirstCoordinate().getI());
        coordinateToRetrieve.setJ(digraph.getSecondCoordinate().getJ());
        return coordinateToRetrieve;
    }


    private String encryptColumnRule(Digraph digraph) {
        // Column rule is when the digraph is in the same column and means that you shift the letters down
        // wrapping around the next column if it's at the bottom of the table
        String encryptedDigraph = "" + cipher.getLetterAtCoordinate(
                determineCoordinateForColumnRule(digraph.getFirstCoordinate()));

        encryptedDigraph = encryptedDigraph + cipher.getLetterAtCoordinate(
                determineCoordinateForColumnRule(digraph.getSecondCoordinate()));
        return encryptedDigraph;
    }

    private Coordinate determineCoordinateForColumnRule(Coordinate coordinate) {
        Coordinate coordinateToRetrieve = new Coordinate();

        if (this.mode == Mode.ENCRYPT) {
            coordinateColumnRuleEncrypt(coordinate, coordinateToRetrieve);
        } else if (this.mode == Mode.DECRYPT) {
            coordinateColumnRuleDecrypt(coordinate, coordinateToRetrieve);
        }
        return coordinateToRetrieve;
    }

    private void coordinateColumnRuleDecrypt(Coordinate coordinate, Coordinate coordinateToRetrieve) {
        if (coordinate.getI() == MIN_I){
            coordinateToRetrieve.setI(MAX_I);
            coordinateToRetrieve.setJ(coordinate.getJ());
        } else {
            coordinateToRetrieve.setI(coordinate.getI() - 1);
            coordinateToRetrieve.setJ(coordinate.getJ());
        }
    }

    private void coordinateColumnRuleEncrypt(Coordinate coordinate, Coordinate coordinateToRetrieve) {
        if (coordinate.getI() == MAX_I){
            coordinateToRetrieve.setI(MIN_I);
            coordinateToRetrieve.setJ(coordinate.getJ());
        } else {
            coordinateToRetrieve.setI(coordinate.getI() + 1);
            coordinateToRetrieve.setJ(coordinate.getJ());
        }
    }

    private String encryptRowRule(Digraph digraph) {
        // Row rule is when the digraph is in the same row and means that you shift the letters right
        // wrapping around to the next column if it's at the end of the table
        String encryptedDigraph = "" + cipher.getLetterAtCoordinate(
                determineCoordinateForRowRule(digraph.getFirstCoordinate()));

        encryptedDigraph = encryptedDigraph + cipher.getLetterAtCoordinate(
                        determineCoordinateForRowRule(digraph.getSecondCoordinate()));
        return encryptedDigraph;
    }

    private Coordinate determineCoordinateForRowRule(Coordinate coordinate) {
        Coordinate coordinateToRetrieve = new Coordinate();
        if (this.mode == Mode.ENCRYPT) {
            coordinateRowRuleEncrypt(coordinate, coordinateToRetrieve);
        } else if (this.mode == Mode.DECRYPT) {
            coordinateRowRuleDecrypt(coordinate, coordinateToRetrieve);
        }

        return coordinateToRetrieve;
    }

    private void coordinateRowRuleDecrypt(Coordinate coordinate, Coordinate coordinateToRetrieve) {
        if (coordinate.getJ() == MIN_J){
            coordinateToRetrieve.setI(coordinate.getI());
            coordinateToRetrieve.setJ(MAX_J);
        } else {
            coordinateToRetrieve.setI(coordinate.getI());
            coordinateToRetrieve.setJ(coordinate.getJ() - 1);
        }
    }

    private void coordinateRowRuleEncrypt(Coordinate coordinate, Coordinate coordinateToRetrieve) {
        if (coordinate.getJ() == MAX_J){
            coordinateToRetrieve.setI(coordinate.getI());
            coordinateToRetrieve.setJ(MIN_J);
        } else {
            coordinateToRetrieve.setI(coordinate.getI());
            coordinateToRetrieve.setJ(coordinate.getJ() + 1);
        }
    }

    private Rule determineRule(Digraph digraph) {
        Rule determinedRule;
        if (isColumnRule(digraph.getFirstCoordinate(), digraph.getSecondCoordinate())){
            determinedRule = Rule.COLUMN;
        } else if (isRowRule(digraph.getFirstCoordinate(), digraph.getSecondCoordinate())) {
            determinedRule = Rule.ROW;
        } else {
            determinedRule = Rule.RECTANGLE;
        }
        return determinedRule;
    }

    private boolean isColumnRule(Coordinate firstLetter, Coordinate secondLetter) {
        boolean lettersInColumn = false;
        if (firstLetter.getJ() == secondLetter.getJ()) {
            lettersInColumn = true;
        }
        return lettersInColumn;
    }

    private boolean isRowRule(Coordinate firstLetter, Coordinate secondLetter) {
        boolean lettersInRow = false;
        if (firstLetter.getI() == secondLetter.getI()) {
            lettersInRow = true;
        }
        return lettersInRow;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    private enum Rule {
        ROW,
        COLUMN,
        RECTANGLE
    }

    public enum Mode {
        ENCRYPT,
        DECRYPT
    }
}
