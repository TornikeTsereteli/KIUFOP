package Inheritance.Calendar;

public class Calendar {

    private EventList events;

    public Calendar() {
        events = null;
    }

    public void addNewEvent(Event event){
        if(events == null){
            events = new EventList(event,null);
        }else{
            events.addEvent(event);
        }
    }

    public Event[] eventsAt(int day){
        int cnt = 0;
        for(EventList l = events; l!=null; l = l.next){
            if(l.event.diff(day) == 0){
                cnt++;
            }
        }
        Event[] arr = new Event[cnt];
        int index = 0;
        for(EventList l = events; l!=null; l = l.next){
            if(l.event.diff(day) == 0){
                arr[index] = l.event;
                index++;
            }
        }
        return arr;
    }

    public Event nextEvent(int day){
        Event[] arr = eventsAt(day);
        if(arr.length > 0){
            return arr[0];
        }
        return null;
    }


}
