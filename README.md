# Mutants
Detection of mutants based on DNA sequences.

## Tecnologies and tools
* Java 17 [download here](https://www.oracle.com/java/technologies/downloads/#jdk17-windows)
* Spring Boot 2.6.6
* Gradle

## API
URL: https://mutants-pdn.ue.r.appspot.com

## How use
Detect whether a human is a mutant based on their DNA sequence:

* Method: POST
* Url: https://mutants-pdn.ue.r.appspot.com/mutant/
* Body
```json
{
  "dna": [
    "ATGCGA",
    "CAGTGC",
    "TTATGT",
    "AGAAGG",
    "CCCCTA",
    "TCACTG"
  ]
}
```

DNA verification statistics:

* Method: GET
* Url: https://mutants-pdn.ue.r.appspot.com/stats