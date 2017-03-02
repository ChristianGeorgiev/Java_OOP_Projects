package ex5;

public class InvalidSongLengthException extends IllegalArgumentException{
    public InvalidSongLengthException(){
        super("Invalid song length.");
    }
}
