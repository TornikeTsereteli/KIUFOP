package Inheritance.Calendar;

public class Event {

    protected int day; // 1 - 365
    private String description;
    private String place;

    public Event(int day, String description, String place) {
        this.day = day;
        this.description = description;
        this.place = place;
    }

    public int diff(int day){
        if(day < this.day){
            return this.day - day;
        }
        return -1;
    }
}
