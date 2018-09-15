/**
 * AddToCourseException
 *
 * Exception thrown for invalid add operations involving the Course class.
 *
 * @author Nicholas Koontz
 *
 * @version date of completion
 *
 */

public class AddToCourseException extends Exception {
    /**
     * Constructs an AddToCourseException with the default message.
     *
     =     */
    public AddToCourseException() {
        //TODO: Call the superclass's constructor with a default message
        Exception massage = new Exception("Sorry you can not add this course.");

    }

    /**
     * Constructs an AddToCourseException with the provided message.
     *
     * @param message Message to be provided to the user in case of exception
     */
    public AddToCourseException(String message) {
        //TODO: Call the superclass's constructor with a the message parameter
        message = "You can not add this course. Sorry.";

    }
}
