Feature: Encrypt using the cipher

  Scenario Outline: Encrypting a word
     Given the PlayFair has started
       And the playfair cipher keyword is <keyword>
       And the playfair is in mode <mode>
      When I enter <new-word>
    Then the message should be <encryptedMessage>

  Examples:
  | keyword | mode | new-word | encryptedMessage |
  | "PLAYFAIREXAMPLE" | "encrypt" | "HIDE THE GOLD IN THE TREE STUMP" | "BMODZBXDNABEKUDMUIXMMOUVIF" |
  | "MONARCHY" | "encrypt" |  "QS" | "ST" |
  | "MONARCHY" | "encrypt" |  "ST" | "TL" |
  | "MONARCHY" | "encrypt" |  "HF" | "FP" |
  | "MONARCHY" | "encrypt" |  "PV" | "VO" |
  | "MONARCHY" | "encrypt" |  "RC" | "MD" |
  | "MONARCHY" | "encrypt" | "BALLOON" | "IBSUPMNA" |
  | "MONARCHY" | "encrypt" | "ARTATTACK" | "RMSRSZSRDE" |
  | "MONARCHY" | "encrypt" |  "ST" | "TL" |
  | "POTATO" | "encrypt" |  "C PLUS PLUS IS CRAP" | "HCMSNAMSQLNFSTBV" |
  | "POTATO" | "encrypt" |  "c plus plus is crap" | "HCMSNAMSQLNFSTBV" |
  | "POTATO" | "encrypt" |  "cplusplusiscrap" | "HCMSNAMSQLNFSTBV" |
  | "potato" | "encrypt" |  "cplusplusiscrap" | "HCMSNAMSQLNFSTBV" |