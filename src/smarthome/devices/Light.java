package smarthome.devices;

public class Light extends SmartDevice {
    private int brightness;

    public Light(int id, String name) {
        super(id, name);
        this.brightness = 50;
    }

    public void setBrightness(int brightness) {
        if (brightness >= 0 && brightness <= 100) {
            this.brightness = brightness;
        }
    }

    @Override
    public String getStatus() {
        return "Light{id=" + getId() +
                ", name='" + getName() + '\'' +
                ", on=" + isOn() +
                ", brightness=" + brightness + "}";
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
            case "increase":
                setBrightness(Math.min(100, brightness + 10));
                break;
            case "decrease":
                setBrightness(Math.max(0, brightness - 10));
                break;
            default:
                break;
        }
    }
}
