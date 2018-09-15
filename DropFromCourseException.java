/**
 * DropFromCourseException
 *
 * Exception thrown for invalid drop operations involving the Course class.
 *
 * @author Nicholas Koontz
 *
 * @version date of completion
 *
 */

public class DropFromCourseException extends Exception {
    /**
     * Constructs a DropFromCourseException with the default message.
     */
    public DropFromCourseException() {
        //TODO: Call the superclass's constructor with a default message
        Exception massage = new Exception("Sorry you can not add this course.");

    }

    /**
     * Constructs a DropFromCourseException with the provided message.
     *
     * @param message Message to be provided to the user in case of exception
     */
    public DropFromCourseException(String message) {
        //TODO: Call the superclass's constructor with a the message parameter
        message = "You can not drop from this course. You must stay in this course. Sorry";

    }
}
