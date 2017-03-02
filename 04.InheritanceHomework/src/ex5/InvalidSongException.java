package ex5;

public class InvalidSongException extends IllegalArgumentException {
    public InvalidSongException(){
        super("Invalid song.");
    }

}
