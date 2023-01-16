import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Album album1=new Album("Moosa", "Sidhu Moosewala");
        album1.addSongToAlbum("295", 4.05);
        album1.addSongToAlbum("Last Ride", 5.05);
        album1.addSongToAlbum("So High", 3.05);

        Album album2=new Album("Arijit's Songs", "Arijit Singh");
        album2.addSongToAlbum("Kesariya", 5.00);
        album2.addSongToAlbum("tum hi ho", 3.40);
        album2.addSongToAlbum("Hawayein", 4.10);
        album2.addSongToAlbum("Jo bheji thi dua", 3.30);



        System.out.println(album1.findSong("295"));

        LinkedList<Song> myPlayList=new LinkedList<>();
        album1.addToPlaylistFromAlbum("295", myPlayList);
    }
}