# Readability Score

This Java program calculates the readability score of a given text. The program takes a file path as input and analyzes the text file to determine various readability metrics such as the number of words, sentences, characters, syllables, and polysyllables. It then provides readability scores using different algorithms such as Automated Readability Index (ARI), Flesch-Kincaid Readability Tests (FK), Simple Measure of Gobbledygook (SMOG), and Coleman-Liau Index (CL).

## Usage

To use this program, follow the steps below:

1. Provide the file path as a command-line argument when executing the program.
2. The program will read the text from the specified file and display it.
3. Enter the score you want to calculate: ARI, FK, SMOG, CL, or all.
4. The program will calculate and display the corresponding readability score(s) based on your selection.

## Prerequisites

- Java Development Kit (JDK) installed

## How to Run

1. Compile the Java source file:

```shell
javac ReadabilityScore.java
```

2. Run the compiled program with the file path as an argument:

```shell
java ReadabilityScore <file_path>
```

Replace `<file_path>` with the path to the text file you want to analyze.

## Example

Suppose you have a text file named "sample.txt" containing the following text:

```
This is a sample text. It has multiple sentences. Each sentence demonstrates the program's functionality.
```

To calculate the readability scores for this text, run the following command:

```shell
java ReadabilityScore sample.txt
```

The program will display the text and prompt you to enter the score you want to calculate. If you enter "all," it will calculate all available scores. Here's an example output:

```
The text is:
This is a sample text. It has multiple sentences. Each sentence demonstrates the program's functionality.
Words: 15
Sentences: 3
Characters: 91
Syllables: 27
Polysyllables: 3
Enter the score you want to calculate (ARI, FK, SMOG, CL, all): all

Automated Readability Index: 9.64 (about 15-year-olds).
Flesch–Kincaid readability tests: 7.60 (about 13-year-olds).
Simple Measure of Gobbledygook: 8.84 (about 14-year-olds).
Coleman–Liau index: 13.95 (about 24-year-olds).

This text should be understood in average by 16.50-year-olds.
```

## Algorithm Explanation

The program follows these steps to calculate readability scores:

1. Read the text from the specified file.
2. Split the text into sentences using punctuation marks as delimiters.
3. Split each sentence into words.
4. Calculate the number of words, sentences, characters, syllables, and polysyllables.
5. Prompt the user to enter the score they want to calculate.
6. Based on the user's input, calculate the corresponding readability score using the appropriate formula.
7. Determine the reading age based on the score.
8. Display the calculated score and reading age.

Note: The program assumes that words are separated by whitespace and that sentences end with the punctuation marks ".", "!", or "?".

Feel free to customize the program or modify the algorithm to suit your specific needs.

## Developer
This project was developed by PANKAJ AMBEKAR.

- Email: ambekarpankaj@outlook.com

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvement, please open an issue or submit a pull request.

## Contact
If you have any questions or suggestions regarding this project, feel free to contact the maintainer at ambekarpankaj@outlook.com.
