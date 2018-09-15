/**
 * CS180 - Project 02
 *
 * This is the class for the game Connect 4 with all of the methods that are needed in order to be able to run and play the game.
 *
 * Nicholas Koontz, nkoontz@purdue.edu, LE1
 *
 * version 01 07-01-2018
 */

import java.util.*;

public class Connect4 {
    private Scanner s;
    private char[][] board;

    public Connect4() {
        s = new Scanner(System.in);
        this.board = new char[6][7];
        for (int i = 0; i < this.board.length; i++) {
            Arrays.fill(this.board[i],' ');
        }

    }
    public char[][] getBoard(){


        return board.clone();
    }

    public int putPiece(int column, char color) {
        int row = -1;
        for(row = 5; row >= 0;row--){
            if(this.board[row][column] == ' '){
                this.board[row][column] = color;
                return row;
            }
        }
        return row;
    }
    public char checkAlignment(int row, int column) {
        char winner = ' ';
        char played = this.board[row][column];
        int count = 0;
        //vert
        for (int i = 0; row+i <= 5; i++) {
            if(this.board[row+i][column] == played){
                count++;
            }
            else{
                count = 0;
            }
            if(count >=4){
                winner = played;
                return winner;
            }
        }
        count = 0;
        for (int i = 0; row-i >= 0; i++) {
            if(this.board[row-i][column] == played){
                count++;
            }
            else{
                count = 0;
            }
            if(count >=4){
                winner = played;
                return winner;
            }
        }
        count = 0;
        //horiz
        for (int i = 0; i <= 6; i++) {
            if (this.board[row][i] == played) {
                count++;
            } else {
                count = 0;
            }
            if (count >= 4) {
                winner = played;
                return winner;
            }
        }
//        count = 0;
//        for (int i = 0; column-i >= 0; i++) {
//            if (this.board[row][column - i] == played) {
//                count++;
//            } else {
//                count = 0;
//            }
//            if (count >= 4) {
//                winner = played;
//                return winner;
//            }
//        }
        count = 0;


            for (int i = 0, j = 0; column + j <= 6 && row+i <= 5; j++,i++) {
                if (this.board[row+i][column + j] == played) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= 4) {
                    winner = played;
                    return winner;
                }

            }


        count = 0;
            int startRow = row;
            int startColumn = column;

            while(startRow<5 && startColumn>0){
                startRow++;
                startColumn--;
            }
            for (int i = startRow, j = startColumn; j <= 6 && i >= 0; j++, i--) {
                if (this.board[i][j] == played) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= 4) {
                    winner = played;
                    return winner;
                }

            }
        count = 0;

        startRow = row;
        startColumn = column;

        while(startRow>0 && startColumn>0){
            startRow--;
            startColumn--;
        }
            for (int i = startRow, j = startColumn; j <= 6 && i <= 5; j++, i++) {
                if (this.board[i][j] == played) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= 4) {
                    winner = played;
                    return winner;
                }

            }
        count = 0;
        return winner;
    }
//        for(int i = 0; i< row;i++){
//            for (int j = 0; j < column; j++) {

//                    if (this.board[i][j] == 'O' && this.board[i][j + 1] == 'O' && this.board[i][j + 2] == 'O' && this.board[i][j + 3] == 'O'
//                            || this.board[i][j] == 'O' && this.board[i + 1][j] == 'O' && this.board[i + 2][j] == 'O' && this.board[i + 3][j] == 'O') {
//                        winner = 'O';
//                    }
//                    else if (this.board[i][j] == 'X' && this.board[i][j + 1] == 'X' && this.board[i][j + 2] == 'X' && this.board[i][j + 3] == 'X'
//                            || this.board[i][j] == 'X' && this.board[i + 1][j] == 'X' && this.board[i + 2][j] == 'X' && this.board[i + 3][j] == 'X') {
//                        winner = 'X';
//                    }
//                    else if (this.board[i][j] == 'X' && this.board[i+1][j + 1] == 'X' && this.board[i+2][j + 2] == 'X' && this.board[i+3][j + 3] == 'X') {
//                        winner = 'X';
//                    }
//                    else if (this.board[i][j] == 'O' && this.board[i+1][j + 1] == 'O' && this.board[i+2][j + 2] == 'O' && this.board[i+3][j + 3] == 'O') {
//                        winner = 'O';
//                    }
//                    else if (this.board[i][j] == 'X' && this.board[i + 1][j - 1] == 'X' && this.board[i + 2][j - 2] == 'X' && this.board[i + 3][j - 3] == 'X') {
//                        winner = 'X';
//                    } else if (this.board[i][j] == 'O' && this.board[i + 1][j - 1] == 'O' && this.board[i + 2][j - 2] == 'O' && this.board[i + 3][j - 3] == 'O') {
//                        winner = 'O';
//                    } else {
//                        winner = ' ';
//                    }
//                    if(this.board[i][j] == 'X' && this.board[i][j+1] == 'X' && this.board[i][j+2] == 'X' && this.board[i][j+3] == 'X') {
//                            winner = 'X';
//                    }
//                    else if (this.board[i][j] == 'O' && this.board[i][j+1] == 'O' && this.board[i][j+2] == 'O' && this.board[i][j+3] == 'O') {
//                        winner = 'O';
//                    }
//                    if(this.board[i][j] == 'X' && this.board[i+1][j] == 'X' && this.board[i+2][j] == 'X' && this.board[i+3][j] == 'X') {
//                        winner = 'X';
//                    }
//                    else if (this.board[i][j] == 'O' && this.board[i+1][j] == 'O' && this.board[i+2][j] == 'O' && this.board[i+3][j] == 'O') {
//                        winner = 'O';
//                    }

    public void printScreen(){
        char[][] t = getBoard();
        char[] rows = new char[6];
        char[] columns = new char[7];
        int k = 0;
        for (k = 0; k < t.length; k++) {
            rows[k] += 'A'+k;
        }
        for (k = 0; k < t.length+1; k++) {
            columns[k] += '0'+k;

        }
        System.out.println("   "+Arrays.toString(columns)
                .replace("[", "")
                .replace(" ", "")
                .replace(",", " ")
                .replace("]", ""));
        System.out.println("  ---------------");

        for (int b = 0; b < 6; b++) {
            System.out.print(rows[b]+ " |");
            for (int i = 0; i < 7; i++) {
                System.out.print(t[b][i]+"|");
            }
            System.out.println();
            System.out.println("  ---------------");
        }

    }
    public void play(){
        int turn = 0;
        int column = 0;
        int rows = 0;
        do{
            printScreen();

            char color = ' ';
            if (turn % 2 == 0) {
                color = 'O';
            } else {
                color = 'X';
            }
            System.out.println("Current Player: "+ color);
            System.out.printf("Choose a column: ");
            column = s.nextInt();
            s.nextLine();
            if (column > 7 || column < 0) {
                System.out.printf("Choose a column: ");
                column = s.nextInt();
                s.nextLine();
            }

            rows = putPiece(column, color);


            turn++;
            while(rows == -1){
                System.out.println("Column is full choose another one.");
                System.out.printf("Choose a column: ");
                column = s.nextInt();
                s.nextLine();
                if (column > 7 || column < 0) {
                    System.out.printf("Choose a column: ");
                    column = s.nextInt();
                    s.nextLine();
                }

                rows = putPiece(column, color);
            }

        }while(checkAlignment(rows,column)==' ');
        printScreen();
        System.out.println("!!!  Winner is Player "+ checkAlignment(rows,column)+" !!!");


    }

}