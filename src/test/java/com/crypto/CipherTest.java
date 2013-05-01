package com.crypto;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CipherTest {

    private Cipher cipher;

    @Given("^an empty cipher$")
    public void the_cipher_is_created() throws Throwable {
        if (cipher != null){
            cipher = null;
        }
    }

    @When("^I use a cipher keyword \"([^\"]*)\"$")
    public void I_use_a_cipher_keyword(String keyword) throws Throwable {
        cipher = new Cipher(keyword);
    }

    @Then("^it should initialise the cipher as \"([^\"]*)\"$")
    public void it_should_initialise_the_cipher_as(String cipherAsString) throws Throwable {
        char table[][] = cipher.getTable();
        char[] checkCipherAsArray = cipherAsString.toCharArray();
        int checkCount = 0;
        for (int i=0; i < 5; i++){
            for (int j=0;j<5;j++){
                assertEquals("Char at " + i + "," + j,checkCipherAsArray[checkCount], table[i][j]);
                checkCount++;
            }
        }
    }

    @Test
    public void shouldRemoveExtraX() {
        String message = "HELXLO";
        CypherMessage cypherMessage = new CypherMessage("HELLO");
        assertEquals("HELLO", cypherMessage.stripExtraX(message));
    }
}
