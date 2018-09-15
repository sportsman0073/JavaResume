/**
 * CS180 - Homework 04
 *
 *
 *
 * Nicholas Koontz, nkoontz@purdue.edu, LE1
 *
 * version 01 06-26-2018
 */
import java.util.*;

public class MatrixCalculator {
    public static void main(String[] args){
        int num = 0;
        int i = 0;
        int j = 0;
        String formatString = "";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of first Matrix(format ROW x COL");
        System.out.println("Enter row");
        int row = s.nextInt();
        s.nextLine();
        System.out.println("Enter column");
        int column = s.nextInt();
        s.nextLine();
        int[][] matrixOne = new int[row][column];
        for(i = 0; i<row;i++){
            for(j = 0; j<column;j++){
                System.out.printf("Enter the number for row %d and column %d \n",i,j);
                num = s.nextInt();
                s.nextLine();
                matrixOne[i][j]= num;

            }
        }
        System.out.println("Matrix 1 is:");
        for(int k = 0; k<row;k++) {

            System.out.println(Arrays.toString(matrixOne[k])
                    .replace("[", "")
                    .replace(" ", "")
                    .replace(",", " ")
                    .replace("]", ""));
        }
        int p = 0;
        int q = 0;
        System.out.println("Enter the size of second Matrix(format ROW x COL)");
        System.out.println("Enter row");
        int rowSecond = s.nextInt();
        s.nextLine();
        System.out.println("Enter column");
        int columnSecond = s.nextInt();
        s.nextLine();
        int[][] matrixTwo = new int[rowSecond][columnSecond];
        for(p = 0; p<rowSecond;p++) {
            for (q = 0; q < columnSecond; q++) {
                System.out.printf("Enter the number for row %d and column %d \n", p, q);
               int numSecond = s.nextInt();
                s.nextLine();
                matrixTwo[p][q]= numSecond;

            }
        }
        System.out.println("Matrix 2 is:");
        for(int k = 0; k<rowSecond;k++) {

            System.out.println(Arrays.toString(matrixTwo[k])
                    .replace("[", "")
                    .replace(" ", "")
                    .replace(",", " ")
                    .replace("]", ""));
        }
        int [][] addMatrix = new int[row][column];
        int t = 0;
        int l = 0;
        if(row == rowSecond && column == columnSecond) {
            System.out.println("Result after addition");
            for (t = 0; t < row; t++) {
                for (l = 0; l < column; l++) {
                    addMatrix[t][l] = matrixOne[t][l] + matrixTwo[t][l];
                }
            }
            for(int k = 0; k<row;k++) {

                System.out.println(Arrays.toString(addMatrix[k])
                        .replace("[", "")
                        .replace(" ", "")
                        .replace(",", " ")
                        .replace("]", ""));
            }


        }
        else{
            System.out.println("Matrices size are not the same!");
        }
        System.out.println("Matrix 1 is:");
        for(int k = 0; k<row;k++) {

            System.out.println(Arrays.toString(matrixOne[k])
                    .replace("[", "")
                    .replace(" ", "")
                    .replace(",", " ")
                    .replace("]", ""));
        }

        System.out.println("Matrix 2 is:");
        for(int k = 0; k<rowSecond;k++) {

            System.out.println(Arrays.toString(matrixTwo[k])
                    .replace("[", "")
                    .replace(" ", "")
                    .replace(",", " ")
                    .replace("]", ""));
        }
        int y = 0;
        int z = 0;
        int [][] multiplyMatrix = new int[row][columnSecond];
        if(column == rowSecond){
            System.out.println("Result after multiplication");
            /*for (y = 0; y < row; y++) {
                for (z = 0; z < columnSecond; z++) {
                    multiplyMatrix[y][z] += (matrixOne[y][z] * matrixTwo[0][z]);
                    int x = 1;
                    int v = 1;
                    for(x = 1; x < column; x++){
                        for(v = 1; v < rowSecond; v++) {
                            multiplyMatrix[y][z] += (matrixOne[y][x] * matrixTwo[v][z]);
                        }
                    }
                }
            }*/
            for(z=0; z<columnSecond;z++){
                for(y=0;y<row;y++){
                    for(int x = 0;x<column;x++){
                        multiplyMatrix[y][z] += (matrixOne[y][x]*matrixTwo[x][z]);
                    }
                }
            }
            for(int k = 0; k<row;k++) {

                System.out.println(Arrays.toString(multiplyMatrix[k])
                        .replace("[", "")
                        .replace(" ", "")
                        .replace(",", " ")
                        .replace("]", ""));
            }

        }
        else{
            System.out.println("Matrix size doesn't fit requirement!");
        }


    }
}
