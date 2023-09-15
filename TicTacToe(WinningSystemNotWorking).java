package Belaxin;


import java.util.Scanner;

public class MainTic {
    public static void main( String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] Square = new String[10];
        Square[1] = " ";
        Square[2] = " ";
        Square[3] = " ";
        Square[4] = " ";
        Square[5] = " ";
        Square[6] = " ";
        Square[7] = " ";
        Square[8] = " ";
        Square[9] = " ";
        boolean won =true;
        winChecker(Square, won);
        System.out.println(won);


        while (!won){

            playerOneInput(Square, scanner);
            renderEngine(Square);
            winChecker(Square,won);
            System.out.println(won);
            playerTwoInput(Square, scanner);
            renderEngine(Square);
            winChecker(Square,won);
            System.out.println(won);
            }

        }


    public static void playerOneInput(String[] Square,Scanner scanner) {
        System.out.println("Which square would you like to play player 1?");
        int input = Integer.parseInt(scanner.next());

        if (Square[input]. equals(" ")) {
            Square[input] = "X";
        } else {
            System.out.println("pick an unoccupied square");
            playerOneInput(Square, scanner);
        }


    }

    public static void playerTwoInput(String[] Square,Scanner scanner) {
        System.out.println("Which square would you like to play player 2?");
        int input = Integer.parseInt(scanner.next());

        if (Square[input]. equals(" ")) {
            Square[input] = "O";
        } else {
            System.out.println("pick an unoccupied square");
            playerTwoInput(Square, scanner);
        }


    }
    public static void renderEngine (String[] Square) {
        System.out.println(Square[1]+Square[2]+Square[3] );
        System.out.println(Square[4]+Square[5]+Square[6] );
        System.out.println(Square[7]+Square[8]+Square[9] );

        }

    public static boolean winChecker(String[] Square, boolean won){
        //This checks if anyone has won a row
        if(Square[1].equals(Square[2])&&Square[1].equals(Square[3])&&Square[1].equals("X")^Square[1].equals("O")){
        won = true;}
        if(Square[4].equals(Square[5])&&Square[4].equals(Square[6])&&Square[5].equals("X")^Square[5].equals("O")){
        won = true;}
        if(Square[7].equals(Square[8])&&Square[7].equals(Square[9])&&Square[8].equals("X")^Square[8].equals("O")){
        won = true;}

        //This checks if anyone has won a column
        if(Square[1].equals(Square[4])&&Square[1].equals(Square[7])&&Square[1].equals("X")^Square[1].equals("O")){
        won = true;}
        if(Square[2].equals(Square[5])&&Square[2].equals(Square[8])&&Square[2].equals("X")^Square[2].equals("O")){
        won = true;}
        if(Square[3].equals(Square[6])&&Square[3].equals(Square[9])&&Square[3].equals("X")^Square[3].equals("O")){
        won = true;}

        //This checks if anyone has won diagonally
        if(Square[1].equals(Square[5])&&Square[1].equals(Square[9])&&Square[1].equals("X")^Square[1].equals("O")){
        won = true;}
        if(Square[3].equals(Square[5])&&Square[3].equals(Square[7])&&Square[3].equals("X")^Square[3].equals("O")){
        won = true;}

        return won;



    }



}