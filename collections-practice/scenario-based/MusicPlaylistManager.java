import java.util.*;
// Custom Exception
class SongAlreadyExistsException extends Exception {
    public SongAlreadyExistsException(String msg) {
        super(msg);
    }
}
// Song Class
class Song {
    String name;
    Song(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
// Playlist Manager
class PlaylistManager {
    LinkedList<Song> playlist = new LinkedList<>();
    Stack<Song> recentlyPlayed = new Stack<>();
    Set<String> songSet = new HashSet<>();
    void addSong(String name) throws SongAlreadyExistsException {
        if (songSet.contains(name))
            throw new SongAlreadyExistsException("Song already exists: " + name);
        Song song = new Song(name);
        playlist.add(song);
        songSet.add(name);
    }
    void playSong() {
        if (!playlist.isEmpty()) {
            Song song = playlist.removeFirst();
            recentlyPlayed.push(song);
            System.out.println("Now Playing: " + song);
        }
    }
    void showHistory() {
        System.out.println("\nRecently Played Songs:");
        for (Song s : recentlyPlayed) {
            System.out.println(s);
        }
    }
}
public class MusicPlaylistManager {
    public static void main(String[] args) throws SongAlreadyExistsException {
        Scanner sc = new Scanner(System.in);
        PlaylistManager manager = new PlaylistManager();
        System.out.print("Enter number of songs to add: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter song name: ");
            manager.addSong(sc.nextLine());
        }
        System.out.print("\nEnter number of songs to play: ");
        int p = sc.nextInt();
        for (int i = 0; i < p; i++) {
            manager.playSong();
        }
        manager.showHistory();
    }
}
