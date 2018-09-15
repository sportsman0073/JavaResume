import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * A request handler for a server that performs simple arithmetic operations.
 *
 * <p>CS18000 -- Spring 2018 -- External Communication -- Homework</p>
 */
public final class ArithmeticRequestHandler implements Runnable {
    /**
     * The client socket of this request handler.
     */
    private Socket clientSocket;

    /*
     * Error message constants.
     */

    private static final String ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE;

    private static final String ILLEGAL_OPERATION_NAME_ERROR_MESSAGE;

    private static final String ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE;

    private static final String ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE;

    static {
        ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE = String.format("%s: requests must include an operation name, and two operands all separated by spaces\n", ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_OPERATION_NAME_ERROR_MESSAGE = String.format("%s: the operation name must be part of the protocol\n", ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE = String.format("%s: the first operand must be a valid integer\n", ArithmeticProtocol.ILLEGAL_REQUEST);

        ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE = String.format("%s: the second operand must be a valid integer\n", ArithmeticProtocol.ILLEGAL_REQUEST);
    } //static

    /**
     * Constructs a newly allocated {@code ArithmeticRequestHandler} object with the specified client socket.
     *
     * @param clientSocket the client socket of this request handler
     * @throws IllegalArgumentException if the {@code clientSocket} argument is {@code null}
     */
    public ArithmeticRequestHandler(Socket clientSocket) throws IllegalArgumentException {
        if (clientSocket == null) {
            throw new IllegalArgumentException("clientSocket argument is null");
        } else {
            this.clientSocket = clientSocket;
        } //end if
    } //ArithmeticRequestHandler

    /**
     * Communicates with the client, and processes their requests until they disconnect.
     */
    @Override
    public void run() {
        //TODO implement run() method
        Scanner inputs = null;
        do {
            try {

                inputs = new Scanner(clientSocket.getInputStream());
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                String line = null;
                String[] input = null;
                line = inputs.nextLine();
                input = line.split(" ");
                int secNum = 0;
                int firstNum = 0;
                if ((input.length == 3)) {
                    try {
                        firstNum = Integer.parseInt(input[1]);
                    } catch (Exception e) {
                        writer.write(ILLEGAL_FIRST_OPERAND_ERROR_MESSAGE);
                        writer.flush();
                        writer.close();
                        inputs.close();
                        return;

                    }
                    try {
                        secNum = Integer.parseInt(input[2]);
                    } catch (Exception e) {
                        writer.write(ILLEGAL_SECOND_OPERAND_ERROR_MESSAGE);
                        writer.flush();
                        writer.close();
                        inputs.close();
                        return;
                    }
                    int answer = 0;
                    String answers = "";
                    if (input[0].equals("ADD")) {
                        answer = firstNum + secNum;
                        answers = String.valueOf(answer);
                        writer.write(answers);
                        writer.flush();
                        writer.close();
                        inputs.close();
                        return;
                    } else if (input[0].equals("SUBTRACT")) {
                        answer = firstNum - secNum;
                        answers = String.valueOf(answer);
                        writer.write(answers);
                        writer.flush();
                        writer.close();
                        inputs.close();
                        return;
                    } else if (input[0].equals("MULTIPLY")) {
                        answer = firstNum * secNum;
                        answers = String.valueOf(answer);
                        writer.write(answers);
                        writer.flush();
                        writer.close();
                        inputs.close();
                        return;
                    } else if (input[0].equals("DIVIDE")) {
                        answer = firstNum / secNum;
                        answers = String.valueOf(answer);
                        writer.write(answers);
                        writer.flush();
                        writer.close();
                        inputs.close();
                        return;
                    } else {
                        writer.write(ILLEGAL_OPERATION_NAME_ERROR_MESSAGE);
                        writer.flush();
                        writer.close();
                        inputs.close();
                        return;
                    }
                } else {
                    writer.write(ILLEGAL_NUM_ARGUMENTS_ERROR_MESSAGE);
                    writer.flush();
                    writer.close();
                    inputs.close();
                    return;
                }

            } catch (Exception e) {

            }
        }while(inputs!=null);

    } //run
}