Feature: Store the message to cipher

  Scenario Outline: Break the word into digraphs
    Given the PlayFair has started
     When I enter <new-word>
     Then the digraphs should be <digraph>

  Examples:
  | new-word | digraph |
  | "HELLO WORLD" | "HE LX LO WO RL DZ" |
  | "HELLO WORL" | "HE LX LO WO RL" |
