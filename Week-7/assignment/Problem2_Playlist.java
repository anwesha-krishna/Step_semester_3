// Problem 2. The Playlist
// Songs are stored privately; getSongs() returns a defensive copy so
// external edits never touch the real internal array.

class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.songCount = 0;
    }

    void addSong(String title) {
        if (songCount >= songs.length) {
            System.out.println("Add rejected: playlist is full");
            return;
        }
        songs[songCount] = title;
        songCount++;
    }

    String[] getSongs() {
        String[] copy = new String[songCount];
        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    int getSongCount() {
        return songCount;
    }
}

public class Problem2_Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("p.getSongs()[0] is still: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
