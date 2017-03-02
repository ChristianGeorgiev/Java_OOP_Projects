package ex5;

public class InvalidSongMinutesException extends IllegalArgumentException {
    public InvalidSongMinutesException(){
        super("Song minutes should be between 0 and 14.");
    }
}
