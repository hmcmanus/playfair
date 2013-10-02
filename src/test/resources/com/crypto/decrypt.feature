Feature: Decrypt using the cipher

  Scenario Outline: Decrypting a word
     Given the PlayFair has started
       And the playfair cipher keyword is <keyword>
       And the playfair is in mode <mode>
      When I enter <new-word>
      Then the message should be <decryptedMessage>

    Examples:
  | keyword | mode |new-word | decryptedMessage |
  | "PLAYFAIREXAMPLE" | "decrypt" | "BMODZBXDNABEKUDMUIXMMOUVIF" | "HIDETHEGOLDINTHETREESTUMP" |
  | "MONARCHY" | "decrypt" |  "ST" | "QS" |
  | "MONARCHY" | "decrypt" |  "TL" | "ST" |
  | "MONARCHY" | "decrypt" |  "FP" | "HF" |
  | "MONARCHY" | "decrypt" |  "VO" | "PV" |
  | "MONARCHY" | "decrypt" |  "MD" | "RC" |
  | "MONARCHY" | "decrypt" | "IBSUPMNA" | "BALLOON" |
  | "MONARCHY" | "decrypt" | "RMSRSZSRDE" | "ARTATTACK" |
  | "POTATO" | "decrypt" |  "HCMSNAMSQLNFSTBV" | "CPLUSPLUSISCRAPZ" |
  | "POTATO" | "decrypt" |  "hcmsnamsqlnfstbv" | "CPLUSPLUSISCRAPZ" |
  | "potato" | "decrypt" |  "hcmsnamsqlnfstbv" | "CPLUSPLUSISCRAPZ" |