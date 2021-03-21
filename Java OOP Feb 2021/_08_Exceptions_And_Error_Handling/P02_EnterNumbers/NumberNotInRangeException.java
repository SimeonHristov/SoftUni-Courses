package _08_Exceptions_And_Error_Handling.P02_EnterNumbers;

public class NumberNotInRangeException extends RuntimeException{
    public
    NumberNotInRangeException (String message) {
        super (message);
    }
}
