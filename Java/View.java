package Java;

import Java.controller.Controller;
import Java.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private final Controller controller;
    private final Counter counter = new Counter();

    public View(Controller controller) {
        this.controller = controller;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    public void run() {

        while (true) {
            System.out.println("1 - Показать всех животных");
            System.out.println("2 - Добавить новое животное");
            System.out.println("3 - Показать команды для животных");
            System.out.println("4 - Научить животное новым командам");
            System.out.println("5 - Выход");
            String input = prompt("Выберите действие ");

            String name;
            String answer;
            List<String> commands = new ArrayList<>();

            switch (input) {
                case ("5"):
                    return;
                case ("1"):
                    System.out.println();
                    controller.readAnimals().forEach(System.out::println);
                    System.out.println();
                    break;
                case ("2"):
                    System.out.println("1 - Добавить животное");
                    System.out.println("2 - Добавить вьючное животное");
                    String animalKind = prompt("Выбери команду ");
                    int animalIndex;
                    while (!(animalKind.equals("1") || animalKind.equals("2"))) {
                        System.out.println("Bad command!");
                        System.out.println("1 - Добавить животное");
                        System.out.println("2 - Добавить вьючное животное");
                        animalKind = prompt("Выбери команду ");
                    }
                    if (animalKind.equals("1")) {
                        System.out.println("1 - Добавить собаку");
                        System.out.println("2 - Добавить кота");
                        System.out.println("3 - Добавить хомяка");
                        String animalType = prompt("Выбери команду");
                        while (!(animalType.equals("1") || animalType.equals("2") || animalType.equals("3"))) {
                            System.out.println("Неверная команда");
                            System.out.println("1 - Добавить собаку");
                            System.out.println("2 - Добавить кота");
                            System.out.println("3 - Добавить хомяка");
                            animalType = prompt("Выбери команду ");
                        }
                        if (animalType.equals("1"))
                            animalIndex = 1;
                        else if (animalType.equals("2"))
                            animalIndex = 2;
                        else
                            animalIndex = 3;
                    } else {
                        System.out.println("1 - Добавить лошадь");
                        System.out.println("2 - Добавить верблюда");
                        System.out.println("3 - Добавить осла");
                        String animalType = prompt("Выбери команду ");
                        while (!(animalType.equals("1") || animalType.equals("2") || animalType.equals("3"))) {
                            System.out.println("Неверная команда");
                            System.out.println("1 - Добавить лошадь");
                            System.out.println("2 - Добавить верблюда");
                            System.out.println("3 - Добавить осла");
                            animalType = prompt("Выбери команду ");
                        }
                        if (animalType.equals("1"))
                            animalIndex = 4;
                        else if (animalType.equals("2"))
                            animalIndex = 5;
                        else
                            animalIndex = 6;
                    }
                    name = prompt("Введите имя ");
                    while (name.isEmpty()) {
                        System.out.println("Пустое поле !");
                        name = prompt("Введите имя ");
                    }

                    do {
                        String command = prompt("Введите команду для животного ");
                        commands.add(command);
                        answer = prompt("Добавить команду для животного ? (y/n) ");
                    } while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));
                    try (Counter count = counter.start()) {
                        switch (animalIndex) {
                            case (1):
                                controller.saveAnimal(new Dog(name, commands));
                                break;
                            case (2):
                                controller.saveAnimal(new Cat(name, commands));
                                break;
                            case (3):
                                controller.saveAnimal(new Hamster(name, commands));
                                break;
                            case (4):
                                controller.saveAnimal(new Horse(name, commands));
                                break;
                            case (5):
                                controller.saveAnimal(new Camel(name, commands));
                                break;
                            case (6):
                                controller.saveAnimal(new Donkey(name, commands));
                                break;
                            default:
                                System.out.println("Ошибка !");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    counter.add();
                    break;
                case ("3"):
                    name = prompt("Введите имя животного ");
                    if (!controller.checkAnimal(name)) {
                        System.out.println("Животное не найдено");
                        break;
                    }
                    try {
                        System.out.print("Команда ");
                        System.out.println(Mapper.mapListToStr(controller.readAnimal(name).getCommands()));
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case ("4"):
                    name = prompt("Введите имя ");
                    if (!controller.checkAnimal(name)) {
                        System.out.println("Животное не найдено");
                        break;
                    }
                    do {
                        String command = prompt("Введите команду для животного ");
                        commands.add(command);
                        answer = prompt("Добавить команду для животного ? (y/n) ");
                    } while (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"));
                    controller.teachNewCommand(name, commands);
                    break;
                default:
                    System.out.println("Команда не найдена");
                    break;
            }
        }
    }

    private static class Counter implements AutoCloseable {
        private int count = 0;

        public Counter start() {
            count++;
            return this;
        }

        public void add() {
            count++;
        }

        @Override
        public void close() throws Exception {
            if (this.count == 1000) {
                throw new Exception("Counter should be used in try-with-resources block!");
            }
        }
    }
}