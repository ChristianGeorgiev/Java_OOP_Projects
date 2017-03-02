package ex5;

public class Song {
    private String artistName;
    private String songName;
    private int totalLength;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, int totalLength, int minutes, int seconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setTotalLength(totalLength);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    private void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20){
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 20){
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    public int getTotalLength(){
        return this.totalLength;
    }

    private void setTotalLength(int totalLength) {
        if (totalLength > 899){
            throw new InvalidSongLengthException();
        }
        this.totalLength = totalLength;
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException();
        }
        this.minutes = minutes;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException();
        }
        this.seconds = seconds;
    }
}
