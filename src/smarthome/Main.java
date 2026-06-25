package smarthome;

import smarthome.core.SmartHomeCaretaker;
import smarthome.core.SmartHomeMemento;
import smarthome.core.SmartHomeSystem;
import smarthome.factory.DeviceFactory;
import smarthome.factory.SensorFactory;
import smarthome.scenarios.Scenario;
import smarthome.scenarios.ScenarioAction;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SmartHomeSystem system = SmartHomeSystem.getInstance();
        SmartHomeCaretaker caretaker = new SmartHomeCaretaker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SMART HOME MENU ===");
            System.out.println("1. Add device");
            System.out.println("2. Add sensor");
            System.out.println("3. Show all devices");
            System.out.println("4. Create scenario");
            System.out.println("5. Run scenario");
            System.out.println("6. Generate sensor event");
            System.out.println("7. Show statistics");
            System.out.println("8. Save system state");
            System.out.println("9. Load system state");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addDevice(system, scanner);
                    break;
                case "2":
                    addSensor(system, scanner);
                    break;
                case "3":
                    system.showDevices();
                    break;
                case "4":
                    createScenario(system, scanner);
                    break;
                case "5":
                    System.out.print("Enter scenario name: ");
                    system.runScenario(scanner.nextLine());
                    break;
                case "6":
                    System.out.print("Choose sensor id: ");
                    int sensorId = Integer.parseInt(scanner.nextLine());
                    system.generateSensorEvent(sensorId);
                    break;
                case "7":
                    system.showStatistics();
                    break;
                case "8":
                    System.out.print("Enter file name: ");
                    try {
                        SmartHomeMemento memento = system.saveState();
                        caretaker.save(memento, scanner.nextLine());
                        System.out.println("System state saved successfully.");
                    } catch (IOException e) {
                        System.out.println("Save error: " + e.getMessage());
                    }
                    break;
                case "9":
                    System.out.print("Enter file name: ");
                    try {
                        SmartHomeMemento memento = caretaker.load(scanner.nextLine());
                        system.restoreState(memento);
                        System.out.println("System state loaded successfully.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Load error: " + e.getMessage());
                    }
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Unknown option.");
            }
        }
    }

    private static void addDevice(SmartHomeSystem system, Scanner scanner) {
        System.out.println("Choose device type:");
        System.out.println("1 - Light");
        System.out.println("2 - Thermostat");
        System.out.println("3 - CoffeeMachine");
        System.out.println("4 - SmartWindow");
        String typeChoice = scanner.nextLine();

        String type;
        switch (typeChoice) {
            case "1":
                type = "light";
                break;
            case "2":
                type = "thermostat";
                break;
            case "3":
                type = "coffeemachine";
                break;
            case "4":
                type = "smartwindow";
                break;
            default:
                System.out.println("Unknown device type.");
                return;
        }

        System.out.print("Enter device id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter device name: ");
        String name = scanner.nextLine();

        system.addDevice(DeviceFactory.createDevice(type, id, name));
        System.out.println("Device added successfully.");
    }

    private static void addSensor(SmartHomeSystem system, Scanner scanner) {
        System.out.println("Choose sensor type:");
        System.out.println("1 - MotionSensor");
        System.out.println("2 - TemperatureSensor");
        System.out.println("3 - SmokeSensor");
        String typeChoice = scanner.nextLine();

        String type;
        switch (typeChoice) {
            case "1":
                type = "motion";
                break;
            case "2":
                type = "temperature";
                break;
            case "3":
                type = "smoke";
                break;
            default:
                System.out.println("Unknown sensor type.");
                return;
        }

        System.out.print("Enter sensor id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter sensor name: ");
        String name = scanner.nextLine();

        system.addSensor(SensorFactory.createSensor(type, id, name));
        System.out.println("Sensor added successfully.");
    }

    private static void createScenario(SmartHomeSystem system, Scanner scanner) {
        System.out.print("Enter scenario name: ");
        Scenario scenario = new Scenario(scanner.nextLine());

        while (true) {
            System.out.print("Enter device id for action (or 0 to finish): ");
            int deviceId = Integer.parseInt(scanner.nextLine());

            if (deviceId == 0) {
                break;
            }

            System.out.print("Enter action: ");
            String action = scanner.nextLine();
            scenario.addAction(new ScenarioAction(deviceId, action));
        }

        system.addScenario(scenario);
        System.out.println("Scenario created successfully.");
    }
}
