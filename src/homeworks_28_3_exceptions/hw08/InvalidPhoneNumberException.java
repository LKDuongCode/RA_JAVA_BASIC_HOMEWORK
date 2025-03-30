
package homeworks_28_3_exceptions.hw08;

public class InvalidPhoneNumberException extends IllegalArgumentException{
    public InvalidPhoneNumberException (){
    }

    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}