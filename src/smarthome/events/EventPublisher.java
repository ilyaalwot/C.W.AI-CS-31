package smarthome.events;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EventPublisher implements Serializable {
    private final List<EventObserver> observers = new ArrayList<>();

    public void subscribe(EventObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(SmartEvent event) {
        for (EventObserver observer : observers) {
            observer.onEvent(event);
        }
    }
}
