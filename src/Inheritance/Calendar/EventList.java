package Inheritance.Calendar;

public class EventList {

    protected Event event;
    protected EventList next;

    public EventList(Event event, EventList next) {
        this.event = event;
        this.next = next;
    }

    // e1->e4->e1->e3

    public EventList addEvent(Event event){
        next = new EventList(event,next);
        return this;
    }
}
