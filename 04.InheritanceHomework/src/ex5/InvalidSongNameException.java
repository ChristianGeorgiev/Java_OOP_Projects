package ex5;

public class InvalidSongNameException extends IllegalArgumentException {
    public InvalidSongNameException(){
        super("Song name should be between 3 and 30 symbols.");
    }
}
