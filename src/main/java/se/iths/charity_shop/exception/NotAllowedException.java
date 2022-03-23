package se.iths.charity_shop.exception;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException(String message){
        super(message);
    }

}
