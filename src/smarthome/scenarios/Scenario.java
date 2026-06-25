package smarthome.scenarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scenario implements Serializable {
    private final String name;
    private final List<ScenarioAction> actions = new ArrayList<>();

    public Scenario(String name) {
        this.name = name;
    }

    public void addAction(ScenarioAction action) {
        actions.add(action);
    }

    public String getName() {
        return name;
    }

    public List<ScenarioAction> getActions() {
        return actions;
    }
}
