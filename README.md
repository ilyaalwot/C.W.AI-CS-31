# Smart Home Coursework

Консольний застосунок **"Керування системою Розумний дім"** для курсової роботи з дисципліни **Об'єктно-орієнтоване програмування**.

## Реалізовано
- облік пристроїв і датчиків;
- створення та запуск сценаріїв;
- генерація подій від датчиків;
- збір статистики подій;
- збереження та відновлення стану системи.

## Використані патерни
- **Singleton** — `SmartHomeSystem`
- **Observer** — `EventPublisher`, `EventObserver`, `StatisticsObserver`
- **Factory Method** — `DeviceFactory`, `SensorFactory`
- **Memento** — `SmartHomeMemento`, `SmartHomeCaretaker`
