package SpotiJy;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class Album {

    private String title;
    private int releaseYear;
    private  Song[] songs = new Song[0];

    public Album(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Song[] getSongs() {
        return songs;
    }

    public int addSongs(Song[] songs){
        int cnt = 0;
        for(Song song: songs){
            boolean isUnique = true;
            for(Song albumSongs: this.songs){
                if(albumSongs.equals(song)){
                    isUnique = false;
                    break;
                }
            }
            if(isUnique){
                cnt++;
                this.songs = add(this.songs, song);
            }
        }
        return cnt;
    }


    public Song[] shuffle(){
        Random random = new Random();
        random.nextInt(0,10);

        Song[] songs = Arrays.copyOf(this.songs,this.songs.length);
        for(int i = 0; i < songs.length; i++){
            int r = random.nextInt(0,this.songs.length);
            swap(songs,i,r);
        }
        return songs;
    }

    private void swap(Song[] arr,int i, int j){
        Song temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    private Song[] add(Song[] arr, Song song){
        Song[] songs = new Song[arr.length+1];
        for(int i = 0; i < arr.length; i++){
            songs[i] = arr[i];
        }
        songs[songs.length - 1] = song;

        Function<Integer,Integer> f = (x) -> x+1;

        f.apply(1);
        return songs;
    }



}
