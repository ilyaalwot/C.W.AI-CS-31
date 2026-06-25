package smarthome.events;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

public class StatisticsObserver implements EventObserver, Serializable {
    private int totalEvents = 0;
    private final Map<EventType, Integer> stats = new EnumMap<>(EventType.class);

    @Override
    public void onEvent(SmartEvent event) {
        totalEvents++;
        stats.put(event.getType(), stats.getOrDefault(event.getType(), 0) + 1);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== STATISTICS ===\n");
        sb.append("Total events: ").append(totalEvents).append('\n');

        for (Map.Entry<EventType, Integer> entry : stats.entrySet()) {
            sb.append(entry.getKey())
              .append(": ")
              .append(entry.getValue())
              .append('\n');
        }

        return sb.toString();
    }
}
