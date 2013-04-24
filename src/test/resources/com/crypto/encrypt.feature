Feature: Use the cipher

  Scenario Outline: Encrypting a word
    Given the PlayFair has started
      And the playfair cipher keyword is <keyword>
     When I use a cipher keyword <keyword>
     When I enter <new-word>
     Then it should be encrypted to be <encryptedMessage>

  Examples:
  | keyword | new-word | encryptedMessage |
  | "PLAYFAIREXAMPLE" |"HIDE THE GOLD IN THE TREE STUMP" | "BMODZBXDNABEKUDMUIXMMOUVIF" |
  | "MONARCHY" |"BALLOON" | "IBSUPMNA" |