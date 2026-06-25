package smarthome.scenarios;

import java.io.Serializable;

public class ScenarioAction implements Serializable {
    private final int deviceId;
    private final String action;

    public ScenarioAction(int deviceId, String action) {
        this.deviceId = deviceId;
        this.action = action;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public String getAction() {
        return action;
    }
}
