package SpotiJy;

public class Song {

    private String title;
    private int releaseYear;
    private int duration = 60;
    private int likes = 0;


    public Song(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Song(String title, int releaseYear, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.likes = likes;
    }

    public Song(String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public int getLikes() {
        return likes;
    }

    public boolean changeDuration(int duration){
        if(duration < 0 || duration > 720 || duration == this.duration){
            return false;
        }
        this.duration = duration;
        return true;
    }

    public void like(){
        likes++;
    }

    public void unlike(){
        if(likes > 0){
            likes--;
        }
    }

    @Override
    public String toString() {
        return "Title='" + title + '\'' +
                ", Duration=" + duration +
                ", ReleaseYear=" + releaseYear +
                ", Likes=" + likes;
    }

    public boolean equals(Song song){
        return title.equals(song.title) && duration == song.duration && this.releaseYear == song.releaseYear && this.likes == song.likes;
    }
}
