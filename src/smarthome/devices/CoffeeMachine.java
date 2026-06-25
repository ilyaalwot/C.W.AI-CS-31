package smarthome.devices;

public class CoffeeMachine extends SmartDevice {
    private boolean brewing;

    public CoffeeMachine(int id, String name) {
        super(id, name);
        this.brewing = false;
    }

    @Override
    public String getStatus() {
        return "CoffeeMachine{id=" + getId() +
                ", name='" + getName() + '\'' +
                ", on=" + isOn() +
                ", brewing=" + brewing + "}";
    }

    @Override
    public void performAction(String action) {
        switch (action.toLowerCase()) {
            case "on":
                turnOn();
                break;
            case "off":
                turnOff();
                brewing = false;
                break;
            case "brew":
                turnOn();
                brewing = true;
                break;
            case "stop":
                brewing = false;
                break;
            default:
                break;
        }
    }
}
