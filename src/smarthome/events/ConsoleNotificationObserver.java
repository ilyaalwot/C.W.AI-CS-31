package smarthome.events;

import java.io.Serializable;

public class ConsoleNotificationObserver implements EventObserver, Serializable {
    @Override
    public void onEvent(SmartEvent event) {
        System.out.println("[EVENT] " + event.getType() + " from " + event.getSource());
        System.out.println(event.getDescription());
    }
}
