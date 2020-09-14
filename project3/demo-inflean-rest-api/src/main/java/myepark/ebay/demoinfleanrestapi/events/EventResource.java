package myepark.ebay.demoinfleanrestapi.events;


public class EventResource{
    private Event event;

    public EventResource(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }
}
