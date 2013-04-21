package com.crypto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PlayFair
{
    private CypherMessage cypherMessage;
    private Cipher cipher;

//    public static void main(String[] args){
//        PlayFair playFair = new PlayFair();
//        System.out.println("Enter a message to encrypt:");
//        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
//
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String input;
//        try {
//            while ( ! "EXIT".equals(input = bufferedReader.readLine()) ) {
//                String output = playFair.convertMessageToDigraphs(input);
//                if (null != output) {
//                    System.out.println(output);
//                }
//            }
//        } catch (IOException ioe) {
//            System.out.println("An error has occurred");
//        }
//    }

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
        return encrpyted;
    }

    private String processDigraph(Digraph digraph) {

        return null;
    }
}
