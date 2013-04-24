Feature: Encrypt using the cipher

  Scenario Outline: Encrypting a word
     Given the PlayFair has started
       And the playfair cipher keyword is <keyword>
       And the playfair is in mode <mode>
      When I enter <new-word>
      Then it should be encrypted to be <encryptedMessage>

  Examples:
  | keyword | mode | new-word | encryptedMessage |
  | "PLAYFAIREXAMPLE" | "encrypt" | "HIDE THE GOLD IN THE TREE STUMP" | "BMODZBXDNABEKUDMUIXMMOUVIF" |
  | "MONARCHY" | "encrypt" | "BALLOON" | "IBSUPMNA" |
  | "MONARCHY" | "encrypt" | "ARTATTACK" | "RCSRSZSRDE" |
  | "MONARCHY" | "encrypt" |  "ST" | "TU" |