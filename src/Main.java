import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

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
        album2.addToPlaylistFromAlbum(2,myPlayList);
        album1.addToPlaylistFromAlbum("Last Ride",myPlayList);
        album2.addToPlaylistFromAlbum("Hawayein",myPlayList);

        play(myPlayList);
    }
    public static void play(LinkedList<Song>playList) {
        ListIterator<Song> itr = playList.listIterator();
        Scanner sc = new Scanner(System.in);
        boolean isForward=false;

        if(playList.size()>0){
            System.out.println("Currently playing: ");
            System.out.println(itr.next());
            isForward=true;
        }
        else {
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Enter your choice: ");
        printMenu();

        boolean quite=false;

        while(!quite){
            int choice= sc.nextInt();

            switch (choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                        isForward=true;
                    }
                    else {
                        System.out.println("You have reached the end of playlist");
                        isForward=false;
                    }
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                        isForward=false;
                    }
                    else {
                        System.out.println("You are at start of playlist");
                        isForward=true;
                    }
                    break;
                case 3:
                    if(isForward==true){
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward=false;
                        }
                    }
                    else {
                        if(itr.hasNext()){
                            System.out.println(itr.next());
                            isForward=true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    if(isForward==true){
                        itr.remove();
                        System.out.println("song is deleted successfully");
                    }
                    else{
                        itr.remove();
                        System.out.println("Song is deleted successfully");
                        isForward=true;
                    }
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quite=true;
                    break;

            }
        }
    }

    public static void printSongs(LinkedList<Song>playList){
        for (Song song:playList)
            System.out.println(song);
        return;
    }
    public static void printMenu(){
        System.out.println("Select your choice:");
        System.out.println("1-Play next song");
        System.out.println("2-Play previous song");
        System.out.println("3-Repeat the current song");
        System.out.println("4-Show menu again");
        System.out.println("5-Delete the current song");
        System.out.println("6-Print all the songs in PlayList");
        System.out.println("7-Quit");
    }


}