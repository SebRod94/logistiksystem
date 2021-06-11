package Exceptions;

public class WrongNameException extends Exception{
    public WrongNameException(String ex)
    {
        super(ex);
    }

    public WrongNameException(){
    }
}
