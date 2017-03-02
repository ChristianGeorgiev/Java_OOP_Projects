package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Song> songs = new ArrayList<>();

        int n = Integer.valueOf(console.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = console.readLine().split(";");

            try {
                int minutes = Integer.valueOf(input[2].split(":")[0]);
                int seconds = Integer.valueOf(input[2].split(":")[1]);
                int totalTime = seconds + (minutes * 60);
                Song song = new Song(input[0], input[1], totalTime, minutes, seconds);
                songs.add(song);
                System.out.println("Song added.");
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }

        int totalSeconds = 0;
        for (Song song : songs) {
            totalSeconds+=song.getTotalLength();
        }
        System.out.println("Songs added: " + songs.size());
        System.out.println(calcTotalTime(totalSeconds));
    }

    private static String calcTotalTime(int totalSeconds) {
        int hours = 0;
        int minutes = 0;
        int seconds = totalSeconds;
        while (seconds >= 59){
            seconds -= 60;
            minutes++;
            if (minutes == 60){
                minutes = 0;
                hours++;
            }
        }
        return String.format("Playlist length: %dh %dm %ds%n", hours,minutes,seconds);
    }
}
