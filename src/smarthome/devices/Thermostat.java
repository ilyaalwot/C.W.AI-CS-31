package smarthome.devices;

public class Thermostat extends SmartDevice {
    private int targetTemperature;

    public Thermostat(int id, String name) {
        super(id, name);
        this.targetTemperature = 22;
    }

    public void setTargetTemperature(int targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    @Override
    public String getStatus() {
        return "Thermostat{id=" + getId() +
                ", name='" + getName() + '\'' +
                ", on=" + isOn() +
                ", targetTemperature=" + targetTemperature + "}";
    }

    @Override
    public void performAction(String action) {
        String lower = action.toLowerCase();

        if ("on".equals(lower)) {
            turnOn();
        } else if ("off".equals(lower)) {
            turnOff();
        } else if (lower.startsWith("set")) {
            try {
                int value = Integer.parseInt(lower.substring(3));
                setTargetTemperature(value);
            } catch (NumberFormatException ignored) {
            }
        }
    }
}
