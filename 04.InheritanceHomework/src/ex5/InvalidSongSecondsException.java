package ex5;

public class InvalidSongSecondsException extends IllegalArgumentException {
    public InvalidSongSecondsException(){
        super("Song seconds should be between 0 and 59.");
    }
}
