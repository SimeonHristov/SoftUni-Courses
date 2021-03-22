package _08_Exceptions_And_Error_Handling.P05_CustomException;

public class InvalidPersonNameException extends RuntimeException {

    public InvalidPersonNameException(String massage){
        super(massage);
    }
}