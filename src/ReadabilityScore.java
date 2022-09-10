import java.io.File;
import java.util.Scanner;

public class ReadabilityScore {
    static int avgAge = 0;
    public static void main(String[] args) {

        String filePath = args[0];
        File file = new File(filePath);
        String data = "";
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                data += scanner.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("The text is:\n" + data);

        String[] sentences = data.split("[!?.] ");
        int words = 0;
        int syllables = 0;
        int pollySyllables = 0;
//        String check = ".*[aeiou][^aeiou].*";
        for (String sentence : sentences) {
            String[] word = sentence.split("\\s");
            words += word.length;
            for (String sword : word) {
                String[] chk = sword.split("");
                int count = 0;
                for (int i = 1; i < chk.length; i++) {
                    if (chk[i].matches("[aeiouyAEIOUY]") && !chk[i - 1].matches("[aeiouyAEIOUY]")) {
                        syllables++;
                        count++;
                    }
                }
                if (chk[0].matches("[aeiouyAEIOUY]")) {
                    syllables++;
                    count++;
                }
                if (chk[chk.length - 1].matches("[eE]")) {
                    syllables--;
                    count--;
                }
                if (count == 0) {
                    syllables++;
                }
                if (count > 2) {
                    pollySyllables++;
                }
            }
        }

        String[] chars = data.replaceAll("[ \n\t]", "").split("");
        int characters = chars.length;

        System.out.printf("""
                Words: %d
                Sentences: %d
                Characters: %d
                Syllables: %d
                Polysyllables: %d
                """, words, sentences.length, characters, syllables, pollySyllables);

        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println();

        double chWo = characters * 1.0 / words;
        double woSen = words * 1.0 / sentences.length;

        switch (input) {
            case "all":
                automatedReadabilityIndex(chWo, woSen);
                fleschKincaidReadabilityTests(woSen, syllables, words);
                smogIndex(pollySyllables, sentences.length);
                colemanLiauIndex(characters, words, sentences.length);
                System.out.printf("\nThis text should be understood in average by %.2f-year-olds.",
                        (avgAge * 1.0) / 4);
                break;
            case "ARI":
                automatedReadabilityIndex(chWo, woSen);
                break;
            case "FK":
                fleschKincaidReadabilityTests(woSen, syllables, words);
                break;
            case "SMOG":
                smogIndex(pollySyllables, sentences.length);
                break;
            case "CL":
                colemanLiauIndex(characters, words, sentences.length);
                break;
            default:
                break;
        }
    }

    public static int readingAge(double score) {
        int roundedScore = (int) Math.ceil(score);

        if (roundedScore > 12) {
            return 24;
//            System.out.printf("This text should be understood by %d-%d-year-olds.", 18, 24);
        } else if (roundedScore > 10) {
            return roundedScore + 6;
        } else if (roundedScore > 3) {
            return roundedScore + 5;
//            System.out.printf("This text should be understood by %d-%d-year-olds.", roundedScore + 5, roundedScore + 6);
        } else if (roundedScore == 3) {
            return roundedScore + 9;
//            System.out.printf("This text should be understood by %d-%d-year-olds.", 7, 9);
        } else {
            return roundedScore + 5;
//            System.out.printf("This text should be understood by %d-%d-year-olds.", roundedScore + 4, roundedScore + 5);
        }
    }

    public static void automatedReadabilityIndex(double chWo, double woSen) {
        double score = (4.71 * chWo) + (0.5 * woSen) - 21.43;
        int age = readingAge(score);
        avgAge += age;
        System.out.printf("Automated Readability Index: %.2f (about %d-year-olds).\n", score,
                age);
    }

    public static void fleschKincaidReadabilityTests(double woSen, double syllables, double words) {
        double score = (0.39 * woSen) + (11.8 * (syllables / words)) - 15.59;
        int age = readingAge(score);
        avgAge += age;
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %d-year-olds).\n", score,
                age);
    }

    public static void smogIndex(double pollysyllables, double sentences) {
        double score = (1.043 * Math.sqrt(pollysyllables * (30 / sentences))) + 3.1291;
        int age = readingAge(score);
        avgAge += age;
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %d-year-olds).\n", score,
                age);
    }

    public static void colemanLiauIndex(double characheres, double words,double sentences) {
        double avgChars = characheres / words * 100;
        double avgSentences = sentences / words * 100;
        double score = (0.0588 * avgChars) - (0.296 * avgSentences) - 15.8;
        int age = readingAge(score);
        avgAge += age;
        System.out.printf("Coleman–Liau index: %.2f (about %d-year-olds).\n", score,
                age);
    }
}
