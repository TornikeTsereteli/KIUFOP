package Inheritance.Calendar;

public class InfiniteRepeatEvent extends Event{
    private int period;

    public InfiniteRepeatEvent(int day, String description, String place, int period) {
        super(day, description, place);
        this.period = period;
    }
    @Override
    public int diff(int day) {
        if( day < super.day){
            return super.day - day;
        }

        int d = day - super.day;  // (37 - 25) %  7    39

        if(d%period == 0){
            return 0;
        }

        return period - d % period;

    }
}
