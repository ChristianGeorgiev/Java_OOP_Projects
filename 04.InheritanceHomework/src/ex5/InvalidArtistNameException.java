package ex5;

public class InvalidArtistNameException extends IllegalArgumentException {
    public InvalidArtistNameException() {
        super("Artist name should be between 3 and 20 symbols.");
    }
}
