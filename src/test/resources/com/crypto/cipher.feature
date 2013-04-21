Feature: Create the cipher

  Scenario Outline: Create the cipher from a keyword
    Given an empty cipher
     When I use a cipher keyword <keyword>
     Then it should initialise the cipher as <cipher>

  Examples:
  | keyword | cipher |
  | "MONARCHY" | "MONARCHYBDEFGIKLPQSTUVWXZ" |
  | "SUPERSECRET" | "SUPERCTABDFGHIKLMNOQVWXYZ" |