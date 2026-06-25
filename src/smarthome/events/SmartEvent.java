package smarthome.events;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SmartEvent implements Serializable {
    private final EventType type;
    private final String source;
    private final String description;
    private final LocalDateTime timestamp;

    public SmartEvent(EventType type, String source, String description) {
        this.type = type;
        this.source = source;
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }

    public EventType getType() {
        return type;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + type + " from " + source + ": " + description;
    }
}
