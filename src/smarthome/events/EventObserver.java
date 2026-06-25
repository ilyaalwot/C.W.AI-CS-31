package smarthome.events;

public interface EventObserver {
    void onEvent(SmartEvent event);
}
