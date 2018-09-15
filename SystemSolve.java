import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SystemSolve {
    private double[][] coefficientsMatrix;
    private double[] bVector;
    private double[] solutionVector;
    private int numEquations;

    /**
     * Solves a system of equations given as a lower-triangular matrix.
     */
    private void forwardSolve() {
        // TODO: implement this method
        double[] t = new double[numEquations];
        t[0] = bVector[0] / coefficientsMatrix[0][0];
        for (int i = 1; i < numEquations; i++) {
            double secondPart = 0.0;
            for (int j = 0; j < i; j++) {
                secondPart += coefficientsMatrix[i][j] * t[j];
            }
            t[i] = (bVector[i]-secondPart)/coefficientsMatrix[i][i];
        }
        solutionVector = t;


    }

    /**
     * Solves a system of equations given as an upper-triangular matrix.
     */
    private void backwardSolve() {
        // TODO: implement this method

        double[] t = new double[numEquations];
        t[numEquations-1] = bVector[numEquations-1] / coefficientsMatrix[numEquations-1][0];
        for (int i = numEquations-2; i >= 0; i--) {
            double secondPart = 0.0;
            for (int j = i+1; j <= numEquations-1; j++) {
                secondPart += coefficientsMatrix[i][j-(i)] * t[j];
            }
            t[i] = (bVector[i]-secondPart)/coefficientsMatrix[i][0];
        }
        solutionVector = t;
//            y = (bVector[numEquations-2] - coefficientsMatrix[numEquations - 2][numEquations - 1] * x) / coefficientsMatrix[numEquations - 2][numEquations - 2];
//            z = (bVector[numEquations-1] - coefficientsMatrix[0][numEquations - 1] * y - coefficientsMatrix[0][numEquations - 1] * x) / coefficientsMatrix[0][0];
//            solutionVector = new double[]{x, y, z};
//        if(numEquations==2){
//            x=bVector[0]/coefficientsMatrix[0][0];
//            y = (bVector[numEquations-1]-coefficientsMatrix[0][numEquations-1]*x)/coefficientsMatrix[numEquations-1][numEquations-1];
//            solutionVector = new double[]{x, y};
//        }
    }

    /**
     * Reads the file at the given filename to parse and store the coefficients
     * matrix and the bVector. The file should be a text file starting with a
     * single integer on the first line specifying the total number of equations.
     * The following lines contain the equations, one per line as the coefficients
     * and b-constant.
     * Equations are of the form:
     *
     * a_0*x_0 + a_1*x_1 + ... + a_n-1*x_n-1 = b_n-1
     *
     * listed in the text file as the form:
     *
     * a_0,a_1,...,a_n,b_n
     *
     * The equations represent a system and is given as either an upper
     * triangular system or a lower triangular system.
     *
     * @param filename The name of the file containing the input text
     */
    public double[] parseAndSolve(String filename) throws MissingVariableException, UndeterminedSystemException{
        // TODO: implement this method
        Scanner input = null;
        try {
            input = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        String line = "";
        numEquations = input.nextInt();
        input.nextLine();

        String[] lines = new String[numEquations];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = input.nextLine();
        }

        bVector = new double[numEquations];
        ArrayList<ArrayList<Double>> jaggedArray = new ArrayList<ArrayList<Double>>();


        coefficientsMatrix = new double[numEquations][numEquations];
        for (int i = 0; i < (numEquations -1); i++) {
            ArrayList<Double> row = new ArrayList<Double>();
            if (lines[i].split(",").length == 1){
                throw new MissingVariableException("Not Valid");
            }

            if(Math.abs(lines[i].split(",").length-lines[i+1].split(",").length)!=1){
                throw new UndeterminedSystemException("Not Valid");
            }
            String[] tokens = lines[i].split(",");
            bVector[i] = (Double.parseDouble(tokens[tokens.length-1]));
            if(lines[0].split(",").length > lines[1].split(",").length){

                for (int j = 0; j < tokens.length-1; j++) {
                    //coefficientsMatrix[i][j+i] = Double.parseDouble(tokens[j]);
                    row.add(Double.parseDouble(tokens[j]));
                }
//                    printLowerTriangularMatrix(coefficientsMatrix,bVector);
                //forwardSolve();
            }else if(lines[0].split(",").length < lines[1].split(",").length){
                for (int j = 0; j < tokens.length-1; j++) {
                    //coefficientsMatrix[i][j] = Double.parseDouble(tokens[j]);
                    row.add(Double.parseDouble(tokens[j]));
                }

            }
            jaggedArray.add(row);
        }

        if (lines[numEquations-1].split(",").length == 1){
            throw new MissingVariableException("Not Valid");
        }

//            ArrayList<Double[]> jaggedArray2 = new ArrayList<Double[]>();
//        for (int i = 0; i < jaggedArray.size(); i++) {
//            Double[] temp = new Double[jaggedArray.get(i).size()];
//            jaggedArray2.add(jaggedArray.get(i).toArray(temp));
//        }
//
//        coefficientsMatrix = (jaggedArray2.toArray(new Double[jaggedArray.size()][jaggedArray.size()]));

        if(lines[0].split(",").length > lines[1].split(",").length){
//                String[] tokens = lines[numEquations-1].split(",");
//                coefficientsMatrix[numEquations-1][numEquations-1] = Double.parseDouble(tokens[0]);

            String[] tokens = lines[numEquations-1].split(",");
            ArrayList<Double> row = new ArrayList<Double>();
            row.add(Double.parseDouble(tokens[0]));
            jaggedArray.add(row);
            bVector[numEquations-1] = (Double.parseDouble(tokens[1]));

            coefficientsMatrix = new double[numEquations][numEquations];
            for (int i = 0; i < coefficientsMatrix.length; i++) {
                coefficientsMatrix[i] = new double[jaggedArray.get(i).size()];
                for (int j = 0; j < jaggedArray.get(i).size(); j++) {
                    coefficientsMatrix[i][j] = jaggedArray.get(i).get(j);
                }
            }
            backwardSolve();
        } else {
//                String[] tokens = lines[numEquations-1].split(",");
//                for (int i = 0; i < numEquations; i++) {
//                    coefficientsMatrix[numEquations-1][i] = Double.parseDouble(tokens[i]);
//
//                }
            String[] tokens = lines[numEquations-1].split(",");
            bVector[numEquations-1] = (Double.parseDouble(tokens[numEquations]));
            ArrayList<Double> row = new ArrayList<Double>();
            for (int i = 0; i < numEquations; i++) {
                row.add(Double.parseDouble(tokens[i]));
            }

            jaggedArray.add(row);

            coefficientsMatrix = new double[numEquations][numEquations];
            for (int i = 0; i < coefficientsMatrix.length; i++) {
                coefficientsMatrix[i] = new double[jaggedArray.get(i).size()];
                for (int j = 0; j < jaggedArray.get(i).size(); j++) {
                    coefficientsMatrix[i][j] = jaggedArray.get(i).get(j);
                }
            }

            forwardSolve();
        }



        return solutionVector;
    }

    /**
     * Prints the given coefficients matrix and solution vector as a system
     * with matrix formatting as a lower triangular matrix.
     *
     * @param matrix The coefficients matrix
     * @param vector The solution vector
     */
    void printLowerTriangularMatrix(double[][] matrix, double[] vector) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.3f\t", matrix[i][j]);
            }
            for (int k = matrix.length - 1; k > i; k--) {
                System.out.print("\t");
            }
            System.out.printf("| %.3f%n", vector[i]);
        }
        System.out.println();
    }

    /**
     * Prints the given coefficients matrix and solution vector as a system
     * with matrix formatting as an upper triangular matrix.
     *
     * @param matrix The coefficients matrix
     * @param vector The solution vector
     */
    void printUpperTriangularMatrix(double[][] matrix, double[] vector) {
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < i; k++) {
                System.out.print("\t");
            }
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%.3f\t", matrix[i][j]);
            }
            System.out.printf("| %.3f%n", vector[i]);
        }
        System.out.println();
    }

    /**
     * Prints the given vector as a column vector.
     *
     * @param vector The vector to print
     */
    void printVector(double[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("%3.3f%n", vector[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SystemSolve hi = new SystemSolve();

        try {
            hi.parseAndSolve("lower-tri.txt");
        } catch (MissingVariableException e) {
            e.printStackTrace();
        } catch (UndeterminedSystemException e) {
            e.printStackTrace();
        }
    }
}