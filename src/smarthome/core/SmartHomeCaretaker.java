package smarthome.core;

import java.io.*;

public class SmartHomeCaretaker {
    public void save(SmartHomeMemento memento, String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(memento);
        }
    }

    public SmartHomeMemento load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (SmartHomeMemento) in.readObject();
        }
    }
}
