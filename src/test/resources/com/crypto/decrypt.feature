Feature: Decrypt using the cipher

  Scenario Outline: Decrypting a word
     Given the PlayFair has started
       And the playfair cipher keyword is <keyword>
       And the playfair is in mode <mode>
      When I enter <new-word>
      Then it should be encrypted to be <decryptedMessage>

    Examples:
  | keyword | mode |new-word | decryptedMessage |
  | "PLAYFAIREXAMPLE" | "decrypt" | "BMODZBXDNABEKUDMUIXMMOUVIF" | "HIDETHEGOLDINTHETREXESTUMP" |
  | "MONARCHY" | "decrypt" | "IBSUPMNA" | "BALXLOON" |
  | "MONARCHY" | "decrypt" | "RCSRSZSRDE" | "ARTATXTACK" |
  | "MONARCHY" | "decrypt" |  "TU" | "ST" |