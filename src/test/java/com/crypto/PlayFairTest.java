package com.crypto;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.*;

public class PlayFairTest {
    private PlayFair playFair;

    @Given("^the PlayFair has started$")
    public void the_playfair_has_started() throws Throwable {
        playFair = new PlayFair();
    }

    @Given("^the playfair cipher keyword is \"([^\"]*)\"$")
    public void the_playfair_cipher_keyword_is(String keyword) throws Throwable {
        playFair.setCipher(new Cipher(keyword));
    }

    @When("^I enter \"([^\"]*)\"$")
    public void I_enter(String newWord) throws Throwable {
        playFair.convertMessageToDigraphs(newWord);
    }

    @Then("^the digraphs should be \"([^\"]*)\"$")
    public void the_digraphs_should_be_(String output) throws Throwable {
        List<Digraph> digraphList = playFair.getCipherMessage().getDigraphs();
        if (digraphList == null){
            fail("Output null");
        }
        String allDigraphs = "";
        for (Digraph digraph:digraphList){
            if (allDigraphs == ""){
                allDigraphs = digraph.toString();
            } else {
                allDigraphs = allDigraphs + " " + digraph.toString();
            }
        }
        assertEquals(output, allDigraphs);
    }

    @Then("^it should be encrypted to be \"([^\"]*)\"$")
    public void it_should_be_encrypted_to_be(String expectedEncryption) throws Throwable {
        String encryptedMessage = playFair.encrypt();
        assertEquals(expectedEncryption, encryptedMessage);
    }
}
