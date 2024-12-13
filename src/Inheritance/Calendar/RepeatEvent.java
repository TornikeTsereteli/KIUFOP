package Inheritance.Calendar;

public class RepeatEvent extends InfiniteRepeatEvent{

    private int end;

    public RepeatEvent(int day, String description, String place, int period, int end) {
        super(day, description, place, period);
        this.end = end;
    }

    @Override
    public int diff(int day) {
        int d = super.diff(day);
        if(day + d > end){
            return  -1;
        }
        return d;
    }
}
