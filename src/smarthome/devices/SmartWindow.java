package smarthome.devices;

public class SmartWindow extends SmartDevice {
    private boolean opened;

    public SmartWindow(int id, String name) {
        super(id, name);
        this.opened = false;
    }

    @Override
    public String getStatus() {
        return "SmartWindow{id=" + getId() +
                ", name='" + getName() + '\'' +
                ", on=" + isOn() +
                ", opened=" + opened + "}";
    }

    @Override
    public void performAction(String action) {
        switch (action.toLowerCase()) {
            case "on":
                turnOn();
                break;
            case "off":
                turnOff();
                break;
            case "open":
                opened = true;
                break;
            case "close":
                opened = false;
                break;
            default:
                break;
        }
    }
}
