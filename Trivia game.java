package Belaxin;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //input setup
        Scanner scanner = new Scanner(System.in);

        //initialized strings and integers for later use
        int playerScore = 0;
        String playerAnswer1;
        int playerAnswer2;
        String playerAnswer3;

        //these are the questions and answers
        String question1 = "What colour eggs do araucana chickens lay?";
        String answer1 = "green";

        String question2 = "how many hens are recommended per rooster?";
        int answer2 = 10;

        String question3 = "Can chickens change gender?";
        String answer3 = "yes";

        //this is the welcoming message
        System.out.println("");
        System.out.println("Welcome to chicken trivia, have a guess and we'll see how knowledgeable you are in chickens");
        //These are the inputs and checking if answer is correct
        System.out.println("");
        System.out.println(question1);

        playerAnswer1 = scanner.next();
        if (answer1.equals(playerAnswer1)) {
            System.out.println("Correct");
            playerScore++;
        } else {
            System.out.println("incorrect the correct answer is " + answer1);
        }

        System.out.println("");
        System.out.println(question2);

        playerAnswer2 = scanner.nextInt();
        if (answer2 == playerAnswer2) {
            System.out.println("Correct");
            playerScore++;
        } else {
            System.out.println("incorrect the correct answer is " + answer2);
        }

        System.out.println("");
        System.out.println(question3);
        playerAnswer3 = scanner.next();

        if (answer3.equals(playerAnswer3)) {
            System.out.println("Correct");
            playerScore++;
        } else {
            System.out.println("incorrect the correct answer is " + answer3);
        }


        //This is the scoring system

        if (playerScore == 0) {
            System.out.println("What a bummer better luck next time.");
        }

        else if (playerScore == 1) {
            System.out.println("Uh you could've done better");
        }

        else if (playerScore == 2) {
            System.out.println("Great job only one question wrong");
        }

        else if (playerScore == 3) {
            System.out.println("Wow a perfect score you must be a chicken pro");
        }

        else if (playerScore > 3) {
            System.out.println("wait how did yo-");
        }

    }

}